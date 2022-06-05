package edu.ronaldmirabal.diplomado.week6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise1Week6Test {
    private static final String BAD_MIMETYPES_PATH = "./src/test/resources/BadMimetypes.csv";

    private static final String APPLICATION_PATH = "./mimetypes/application.csv";
    private static final String AUDIO_PATH = "./mimetypes/audio.csv";
    private static final String FONT_PATH = "./mimetypes/font.csv";
    private static final String IMAGE_PATH = "./mimetypes/image.csv";
    private static final String MESSAGE_PATH = "./mimetypes/message.csv";
    private static final String MODEL_PATH = "./mimetypes/model.csv";
    private static final String MULTIPART_PATH = "./mimetypes/multipart.csv";
    private static final String TEXT_PATH = "./mimetypes/text.csv";
    private static final String VIDEO_PATH = "./mimetypes/video.csv";

    private final Exercise1Week6 exercise1Week6 = new Exercise1Week6();

    @ParameterizedTest
    @CsvFileSource(files = BAD_MIMETYPES_PATH)
    void badMineTypeTest(String minetype){
        assertFalse(exercise1Week6.isValidMimetype(minetype));
    }


    @ParameterizedTest
    @CsvFileSource(files = {APPLICATION_PATH, AUDIO_PATH, FONT_PATH, IMAGE_PATH, MESSAGE_PATH, MODEL_PATH, MULTIPART_PATH, TEXT_PATH, VIDEO_PATH})
    void goodMineTypeTest(String minetype){
        assertTrue(exercise1Week6.isValidMimetype(minetype));
    }


}