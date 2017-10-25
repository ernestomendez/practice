package com.dxesoft;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

    private Deque<String> deque = new ArrayDeque<>();
    private String textToPrint = "";
//    private boolean balanced;

    public void tagExtractor(String text) {

        boolean balanced = true;

        int position = 0;

        if (text.charAt(position) == '<') {
            String tag = extractTag(text);
            position = tag.length();

            if (position > 0) {
                balanced = queue(tag);
            } else {
                balanced = false;
            }

        } else {
            textToPrint = extractText(text);
            position = textToPrint.length();
        }

        if (!balanced || textToPrint.equals("None")) {
            textToPrint = "None";
            deque.clear();
            System.out.println(textToPrint);
            textToPrint = "";
        } else {
            String substring = text.substring(position);

            if (deque.isEmpty()) {
                System.out.println(textToPrint);

                if (substring.length() > 0) {
                    tagExtractor(substring);
                }
            } else {
                if (position < text.length()) {

                    tagExtractor(substring);
                }
            }

        }


    }

    private String extractTag(String text) {
        String chars = "<[^>]*>";
        Pattern pattern = Pattern.compile(chars);
        Matcher matcher = pattern.matcher(text);

        String tag = "";
        if (matcher.find()) {
            tag = matcher.group();
        }

        return tag;
    }

    private String extractText(String text) {
        int position = text.indexOf('<');

        if (position > 0) {
            return text.substring(0,position);
        } else {
            return "None";
        }

    }

    private boolean queue(String tag) {

        boolean balanced = true;

        if (tag.indexOf("/") == 1) {
            balanced = remove(tag);
        } else {
            deque.addFirst(tag);
        }

        return balanced;
    }

    private boolean remove(String closeTag) {
        if (!deque.isEmpty()) {
            String openTag = deque.removeFirst();

            if (closeTag.length() == openTag.length() + 1) {
                String closingText = closeTag.substring(2, closeTag.length() - 1);

                String openText = openTag.substring(1, openTag.length() - 1);

                return openText.equals(closingText);
            }
        }
        return false;
    }


//    public void tagExtractor(String text) {
//
//        String chars = "<[^>]*>";
//        Pattern pattern = Pattern.compile(chars);
//        Matcher matcher = pattern.matcher(text);
//
//        boolean balanced = false;
//
//        while (matcher.find()) {
//            System.out.println( matcher.group());
//            String tag = matcher.group();
//
//            if (tag.substring(1).equals("/")) {
//                balanced = remove(tag);
//                break;
//            } else {
//                deque.addFirst(tag);
//            }
//        }
//
//        print(text, pattern, balanced);
//
//    }
//
//    private void print(String text, Pattern pattern, boolean balanced) {
//        if (balanced) {
//            Stream<String> stream = Stream.of(text);
//
//            stream.map(pattern::matcher).forEach(System.out::print);
//        } else {
//            System.out.println("None");
//        }
//    }
//
//    private boolean remove(String closeTag) {
//        if (!deque.isEmpty()) {
//            String openTag = deque.removeFirst();
//
//            if (openTag.length() == closeTag.length() + 1) {
//                String closingText = closeTag.substring(2, closeTag.length() - 1);
//
//                String openText = openTag.substring(1, openTag.length() - 1);
//
//                return openText.equals(closingText);
//            }
//        }
//        return false;
//    }
//
//    public void contentExtractor(String text) {
//
//        extract(text, 0);
//
//
//    }
//
////    <h1>Nayeem loves counseling</h1>
////    <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
////    <h1><h1>Sanjay has no watch</h2></h1><par>So wait for a while</par>
////    <h1><h1>Sanjay has no watch</h1></h1>more text<par>So wait for a while</par>
////    <Amee>safat codes like a ninja</amee>
////    <SA premium>Imtiaz has a secret crush</SA premium>
//    private void extract(String text, int index) {
//
//        int position = text.indexOf("<");
//
//        if (position < index) {
//            System.out.println("None");
//        } else if (position == index) {
//            validaTexto(text);
//        } else {
//            System.out.println("None");
//            extract(text, position);
//        }
//    }
//
//    private void validaTexto(String text) {
//
//        int position = text.indexOf('<');
//        if (position == 0) {
//            String tag = extractTag(text);
//            if (queue(tag)) {
//                int index = tag.length();
//                if (index > 0) {
//                    String substring = text.substring(index);
//                    validaTexto(substring);
//                }
//            } else {
//                this.textToPrint = "None";
//            }
//        } else if(position > 0){
//            this.textToPrint = text.substring(0,position);
//            validaTexto(text.substring(position));
//        } else {
//            this.textToPrint = "None";
//        }
//
//
//
//
//    }
//
//    private String extractTag(String text) {
//        String chars = "<[^>]*>";
//        Pattern pattern = Pattern.compile(chars);
//        Matcher matcher = pattern.matcher(text);
//
//        boolean b = matcher.find();
//
//        return matcher.group();
//    }
//
//    private boolean queue(String tag) {
//
//        boolean balanced = true;
//
//        if (tag.indexOf("/") == 1) {
//            balanced = remove(tag);
//        } else {
//            deque.addFirst(tag);
//        }
//
//        return balanced;
//    }
//
//
////    private int extractTag(String text) {
////        String chars = "<[^>]*>";
////        Pattern pattern = Pattern.compile(chars);
////        Matcher matcher = pattern.matcher(text);
////
////        String tag = matcher.group();
////
////        int tagSize = tag.length();
////
////        if (!tag.substring(1).equals("/")) {
////            deque.addFirst(tag);
////            return tagSize;
////        } else {
////            if (remove(tag)) {
////                return tagSize;
////            } else {
////                return -1;
////            }
////        }
////    }
//
////    private void recorreTexto(String text) {
////
////        do {
////
////        }
////    }

}
