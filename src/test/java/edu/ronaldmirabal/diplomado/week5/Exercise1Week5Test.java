package edu.ronaldmirabal.diplomado.week5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class Exercise1Week5Test {
    private final Exercise1Week5 exercise1Week5 = new Exercise1Week5();

    private File catImageFile;
    private int count = 0;

    @BeforeEach
    void beforeEachTest() {
        catImageFile = new File("cat" + count + ".jpg");
        count++;
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("Eliminando archivos");
        for (int i = 0; i < count; i++) {
            File cat = new File("cat" + i + ".jpg");
            if (cat.exists()) {
                if (cat.delete()) {
                    System.out.println("Foto eliminada " + cat.getName());
                } else {
                    System.out.println("No se pudo eliminar la foto " + cat.getName());
                }
            }
        }
    }

    private void saveImage(BufferedImage bufferedImage) throws IOException {
        ImageIO.write(bufferedImage, "jpg", catImageFile);
    }


    @Test
    public void testSaveImageCase() {
        int code = 365;
        BufferedImage image = exercise1Week5.getCatUsingStatusCode(code);
        assertTrue(exercise1Week5.SaveBuffferedImage(image, catImageFile));
    }

    @Test
    public void testNullSaveImageCase() {
        int code = 365;
        BufferedImage image = exercise1Week5.getCatUsingStatusCode(code);
        assertFalse(exercise1Week5.SaveBuffferedImage(image, null));
    }

    @Test
    void noExistCodeTest() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/Cat-404.jpg");
        assertNotNull(inputStream);
        BufferedImage noFoundCat = ImageIO.read(inputStream);

        BufferedImage noExist = exercise1Week5.getCatUsingStatusCode(-1);
        assertNotNull(noExist);
        String expected = Base64.getEncoder().encodeToString(toByteArray(noFoundCat, "jpg"));
        String actual = Base64.getEncoder().encodeToString(toByteArray(noFoundCat, "jpg"));
        assertEquals(expected, actual);
    }

    public static byte[] toByteArray(BufferedImage bufferedImage, String format) throws IOException{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, format,byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


}