
package com.mycompany.mavenproject1;

import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.draw.tool.*;
import org.jhotdraw.text.ColorFormatter;
import org.jhotdraw.util.*;

/**
 *
 * @author HP G4
 */
public class Asal implements Runnable {
            static final int A = 20;
                static final int B = 200;
                static final int C = 300;
                static final int D = 400;
            @Override
            public void run() {
                
                
                
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

                DrawingView view1 = new DefaultDrawingView();
                view1.setDrawing(createDrawing());


                // Create a common drawing editor for the views
                DrawingEditor editor = new DefaultDrawingEditor();
                editor.add(view1);
 

                // Create a tool bar with selection tool and a
                // creation tool for rectangle figures.
                JToolBar tb = new JToolBar();
                ButtonFactory.addSelectionToolTo(tb, editor);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new RectangleFigure()),
                        "edit.createRectangle",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);

                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TriangleFigure()),
                        "edit.createTriangle",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new LineFigure()),
                        "edit.createLine",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new EllipseFigure()),
                        "edit.createEllipse",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TextFigure()),
                        "edit.createText",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                 
                
                
                // Put all together into a JFrame
                JFrame f = new JFrame("Multi-Editor");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(D, C);

                // Set up the content pane
                // Place the toolbar on the left
                // Place each drawing view into a scroll pane of its own
                // and put them into a larger scroll pane.
                JPanel innerPane = new JPanel();
                innerPane.setLayout(new FlowLayout(FlowLayout.LEFT, A, A));
                JScrollPane sp =new JScrollPane(view1.getComponent());
                
                innerPane.add(sp);
                sp.setPreferredSize(new Dimension(B, B));

                sp.setPreferredSize(new Dimension(B, B));
                f.getContentPane().add(new JScrollPane(innerPane));

                f.getContentPane().add(tb, BorderLayout.WEST);

                f.setVisible(true);
            }
          
            private static Drawing createDrawing() {
                // Create a default drawing with
                // input/output formats for basic clipboard support.
                DefaultDrawing drawing = new DefaultDrawing();
                drawing.addInputFormat(new SerializationInputOutputFormat());
                drawing.addOutputFormat(new SerializationInputOutputFormat());
                return drawing;
            }
}

