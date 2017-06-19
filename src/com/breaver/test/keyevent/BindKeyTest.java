/**
 * 
 */
package com.breaver.test.keyevent;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
//import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * @author zzf
 *@date 2017��6��17�� ����5:44:08
 */
public class BindKeyTest {
    JFrame jf = new JFrame("���Լ��̰�");
    JTextArea jta = new JTextArea(5,30);
    JButton jb = new JButton("����");
    JTextField jtf = new JTextField(15);
    public void init() {
        jf.add(jta); // ��������
        JPanel jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);
        jf.add(jp, BorderLayout.SOUTH); // ���������Ͱ�ť


        Action sendMsg = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // �¼�����
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
            }
        };

        // ����¼��������������ť����
        jb.addActionListener(sendMsg);

        // ����Ctrl+Enter��Send
        jtf.getInputMap().put(KeyStroke.getKeyStroke('\n',java.awt.event.InputEvent.CTRL_MASK),"send");
        jtf.getActionMap().put("send",sendMsg);
        jf.pack();
        jf.setVisible(true); // ��ʾ���

    }

    public static void main(String[] args) {
        new BindKeyTest().init();
    }
}