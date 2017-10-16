package fe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileEditorToTest {
    private static FileEditorTo fet;
   @BeforeAll
   public static void setupFet()
   {
       fet = new FileEditorTo("C:\\Users\\admin\\IdeaProjects\\test1\\src\\fe\\files\\1");
   }

    @Test
    public void parsingStrMetod()
    {
        assertEquals(fet.controlChar("123"), "");
//        assertEquals(fet.controlChar("+*/"), "");
//        assertEquals(fet.controlChar("iiijjhj/"), "");
    }

    @Test
    public void wordCountMethod()
    {
        fet.getWordsCount().put("слово", 1);
        assertTrue(fet.getWordsCount().containsKey("слово"));
    }



}