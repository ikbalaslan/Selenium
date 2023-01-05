package tests;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileExistTest {
    @Test
    public void isExistTest(){

       String userDIR = System.getProperty("user.dir");  //=> Gives the path of the current folder
        System.out.println(userDIR);
        String userHome = System.getProperty("user.home"); //=> Gives you the user folder
        System.out.println(userHome);
        // Pick a file on your desktop
        // And verify if that file exist on your computer or not
        String pathOfFile = userHome + "\\Onedrive\\Masaüstü\\logo.jpeg";//Writing the path dynamically so this path can work other laptops
        System.out.println(pathOfFile);
        boolean isExist =Files.exists(Paths.get(pathOfFile));//returns TRUE if file exists.
        Assert.assertTrue(isExist);
    }
}
