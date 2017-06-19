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
 *@date 2017年6月17日 下午5:44:08
 */
public class BindKeyTest {
    JFrame jf = new JFrame("测试键盘绑定");
    JTextArea jta = new JTextArea(5,30);
    JButton jb = new JButton("发送");
    JTextField jtf = new JTextField(15);
    public void init() {
        jf.add(jta); // 内容区域
        JPanel jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);
        jf.add(jp, BorderLayout.SOUTH); // 加入输入框和按钮


        Action sendMsg = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 事件动作
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
            }
        };

        // 添加事件监听器，点击按钮发送
        jb.addActionListener(sendMsg);

        // 关联Ctrl+Enter和Send
        jtf.getInputMap().put(KeyStroke.getKeyStroke('\n',java.awt.event.InputEvent.CTRL_MASK),"send");
        jtf.getActionMap().put("send",sendMsg);
        jf.pack();
        jf.setVisible(true); // 显示组件

    }

    public static void main(String[] args) {
        new BindKeyTest().init();
    }
}