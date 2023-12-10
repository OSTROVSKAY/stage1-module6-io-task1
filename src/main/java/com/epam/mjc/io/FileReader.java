package com.epam.mjc.io;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {

        StringBuilder profileData = new StringBuilder();

        try {

            FileInputStream stream = new FileInputStream(file);

            int i;

            while ((i = stream.read()) != -1) {

                profileData.append((char) i);

            }

            stream.close();

        } catch (IOException e) {

            System.out.println("Problem with read file!");

        }

        String string = profileData.toString();

        String[] splitStrings = string.split("\r\n");

        String[] profileFields = new String[splitStrings.length];

        for (int i = 0; i < splitStrings.length; i++) {

            String[] tempArray = splitStrings[i].split(" ");

            profileFields[i] = tempArray[1];

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
