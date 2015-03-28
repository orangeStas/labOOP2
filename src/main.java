import FactoriesPack.*;
import FiguresPack.FigureList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class main extends JFrame {

    private FigureList list;
    private ArrayList<FiguresFactory> factoriesList;
    ButtonGroup buttonGroup;
    TextArea textArea;

    //ArrayList<Class<?>> figureClassesList;


    public main() {
        list = new FigureList();
        getFactoriesList();
        initGUI();
    }

    private void getFactoriesList() {
        factoriesList = new ArrayList<FiguresFactory>();
        factoriesList.add(new LinesFactory());
        factoriesList.add(new CirclesFactory());
        factoriesList.add(new RectangleFactory());
        factoriesList.add(new RoundRectangleFactory());
        factoriesList.add(new ArcFactory());
        factoriesList.add(new PolyLinesFactory());
        /*
        ArrayList<Class<?>> factoryClassesList = ClassFinder.find("FactoriesPack");
        for (Class factoryClass :factoryClassesList){
            try {
                String nameFactoryClass = factoryClass.getName();
                figureClassesList = ClassFinder.find("FiguresPack");

                for (Class figureClass : figureClassesList) {
                    String nameFigureClass = figureClass.getName();

                    if (nameFactoryClass.contains(nameFigureClass.split("\\.")[1])) {
                        Class<?> FactClass = Class.forName(nameFactoryClass);

                        if (!figureClass.isInterface()) {
                            try {
                                Object object = FactClass.newInstance();
                                factoriesList.add((FigureFactory) object);
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        */

    }

    private void initGUI() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        buttonGroup = new ButtonGroup();
        for (FiguresFactory factory : factoriesList) {
            JRadioButton but = new JRadioButton(factory.getClass().getName().replaceAll("FactoriesPack\\.", "").replaceAll("Factory", ""));
            buttonGroup.add(but);
            add(but);
        }
        textArea = new TextArea();
        textArea.setPreferredSize(new Dimension(200, 50));
        add(textArea);
        Button drawButton = new Button("Draw");
        Button clearButton = new Button("Clear");

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawFigures(e);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFrame(e);
            }
        });


        add(drawButton);
        add(clearButton);
        setLayout(new FlowLayout());
        pack();
    }


    public void drawFigures(ActionEvent e) {
        try {
            for (FiguresFactory factory : factoriesList) {
                String factoryName = factory.getClass().toString().split("\\.")[1].replaceAll("Factory", "");
                String buttonName = getSelectedButtonText(buttonGroup);
                if (factoryName.equals(buttonName)) {
                    list.insertFigure(factory.getFigure(getOptions()));
                }
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            DrawingFrame drawingFrame = new DrawingFrame(list);
            buttonGroup.clearSelection();
        }
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public void clearFrame(ActionEvent e) {
        list.clearList();
        buttonGroup.clearSelection();
    }

    public int[] getOptions() {
        String[] optionsString = textArea.getText().split(" ");
        int[] options = new int[optionsString.length];
        for (int i = 0; i < optionsString.length; i++) {
            try {
                options[i] = Integer.parseInt(optionsString[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return options;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new main().setVisible(true);
            }
        });
    }

}
