package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file)  {

        FileInputStream stream;
        stream = null;

        StringBuilder profileData = new StringBuilder();

        try {
             stream = new FileInputStream(file);

            int i;

            while ((i = stream.read()) != -1) {
                profileData.append((char) i);
            }

        } catch (IOException e) {


            System.err.println("Problem with read file!");
        } finally {

            if(stream != null) {

                try {
                    stream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        String string = profileData.toString();
        String[] splitStrings = string.split("\r\n");



        String[] profileFields = new String[splitStrings.length];



        for (int i = 0; i < splitStrings.length; i++) {

            String[] tempArray = splitStrings[i].split(" ");

            if(tempArray.length > 1) {

                profileFields[i] = tempArray[1];

            } else if(tempArray.length == 1) {

                profileFields[i] = tempArray[0];

            }


        }

        Profile profile = new Profile(
                profileFields[0],
                Integer.parseInt(profileFields[1]),
                profileFields[2],
                Long.parseLong(profileFields[3])
        );




       
        return profile;
        
    }

}
