package com.epam.mjc.nio;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class FileReader {

    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        Map<String,String> map = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] strings = line.split(":");
                map.put(strings[0].trim(), strings[1].trim());
            }

        } catch (FileNotFoundException fileNotFoundException) {
            logger.warning("FileNotFound exception");
        }
        catch (IOException ioException){
            logger.warning("IO exception");
        }
        profile.setAge(Integer.parseInt(map.get("Age")));
        profile.setEmail(map.get("Email"));
        profile.setName(map.get("Name"));
        profile.setPhone(Long.parseLong(map.get("Phone")));

        return profile;
    }
}
