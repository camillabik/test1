package puzzles.jaxb.userXml;

import fe.FileEditorTo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<FileEditorTo> fileEditorToArrayList = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            fileEditorToArrayList.add(new FileEditorTo(args[i]));
        }
        for (FileEditorTo fileEditorTo :fileEditorToArrayList) {
            fileEditorTo.start();
        }
    }
}
