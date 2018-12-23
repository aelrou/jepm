package app;

import app.model.*;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Go {

    public static void main(String[] args) throws WorkDirException, WrapJsonException {

        String workDir = WorkDir.getDir(args, "app.jar");

        File localRunConfigFile = WrapJson.findLocalRunConfig(workDir, "LocalRunConfig.json");
        JsonRunModel localRunConfig = WrapJson.readLocalRunConfig(localRunConfigFile);

        File localLogConfigFile = WrapJson.findLocalLogConfig(workDir, "LocalLogConfig.json");
        JsonLogModel localLogConfig = WrapJson.readLocalLogConfig(localLogConfigFile);

        File localStatusCacheFile = WrapJson.findLocalStatusCache(workDir, "LocalStatusCache.json");
        JsonCacheModel localStatusCache = WrapJson.readLocalStatusCache(localStatusCacheFile);

        LogModel logModel = new LogModel(localLogConfig);
        Log.find(logModel);

        LocalDateTime startClock = LocalDateTime.now();

        try {
            String response = WrapHttpsConnect.useSslSocket(localRunConfig.ENDPOINT_DOMAIN, "");
            Log.save(logModel, response);
            ArrayList<String> messageLines = new ArrayList<>();
            messageLines.add(response);
            EmailModel emailModel = new EmailModel(localRunConfig, localRunConfig.ENDPOINT_NAME, messageLines);
            WrapEmail.sendSecure(emailModel);
            WrapJson.updateLocalStatusCache(localStatusCacheFile, response);
        } catch (WrapHttpsConnectException whce) {
            whce.printStackTrace();
            Log.save(logModel, "Failed to get response");
        } catch (Exception e) {
            e.printStackTrace();
            Log.save(logModel, e.getMessage());
        }
        LocalDateTime stopClock = LocalDateTime.now();
        Duration duration = Duration.between(startClock, stopClock);
        System.out.print("Process time " + duration.getSeconds() + " sec");
    }
}
