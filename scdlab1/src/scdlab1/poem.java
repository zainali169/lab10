package scdlab1;
import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import java.util.StringTokenizer;



public class poem {

    private Frame frame;

    private TextField verseInput;

    private TextArea tokenizedWordsOutput;

    private Panel buttonPanel;

    private List<String> roots;



    public poem() {

        frame = new Frame("Poem Tokenizer");

        frame.setLayout(new BorderLayout());



        verseInput = new TextField();

        tokenizedWordsOutput = new TextArea();

        buttonPanel = new Panel(new FlowLayout());



        loadRootsFromFile("Roots.txt");



        Button tokenizeButton = new Button("Tokenize");

        tokenizeButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                tokenizeVerse();

            }

        });



        frame.add(verseInput, BorderLayout.NORTH);

        frame.add(tokenizedWordsOutput, BorderLayout.CENTER);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(tokenizeButton);



        frame.addWindowListener(new WindowAdapter() {

            @Override

            public void windowClosing(WindowEvent e) {

                System.exit(0);

            }

        });



        frame.setSize(400, 300);

        frame.setVisible(true);

    }



    private void loadRootsFromFile(String filename) {

        roots = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                roots.add(line);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    private void tokenizeVerse() {

        String verse = verseInput.getText();

        StringTokenizer tokenizer = new StringTokenizer(verse);

        tokenizedWordsOutput.setText("");



        while (tokenizer.hasMoreTokens()) {

            String word = tokenizer.nextToken();

            tokenizedWordsOutput.append(word + " ");

            addButtonForWord(word);

        }

    }



    private void addButtonForWord(String word) {

        Button button = new Button(word);

        button.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                assignRootToWord(word);

            }

        });

        buttonPanel.add(button);

    }



    private void assignRootToWord(String word) {

        if (roots != null) {

            // Implement root assignment logic here

            // You can use roots list to display roots in a dialog or perform further actions.

        }

    }



    public static void main(String[] args) {

        new poem();

    }

}