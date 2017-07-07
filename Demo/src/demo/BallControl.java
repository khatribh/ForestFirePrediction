/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 *
 * @author Bhumika
 */
public class BallControl extends JPanel
{
private Ball ball = new Ball();
private JButton jbtSuspend = new JButton("Suspend");
private JButton jbtResume = new JButton("Resume");
private JScrollBar jsbDelay = new JScrollBar();

public BallControl()
{
//group buttons in a panel
JPanel panel = new JPanel();
panel.add(jbtSuspend);
panel.add(jbtResume);

//add ball and buttons to the panel
ball.setBorder(new javax.swing.border.LineBorder(Color.red));
jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
ball.setDelay(jsbDelay.getMaximum());
setLayout(new BorderLayout());
add(jsbDelay, BorderLayout.NORTH);
add(ball, BorderLayout.CENTER);
add(panel, BorderLayout.SOUTH);

//register listeners
jbtSuspend.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
ball.suspend();
}
});

jbtResume.addActionListener(new ActionListener()
{
public void actionPerformed (ActionEvent e)
{
ball.resume();
}
});

jsbDelay.addAdjustmentListener(new AdjustmentListener()
{
public void adjustmentValueChanged(AdjustmentEvent e)
{
ball.setDelay(jsbDelay.getMaximum() - e.getValue());
}
});
}
}
