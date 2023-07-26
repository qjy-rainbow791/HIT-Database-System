package org.example;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DatabaseStatisticsFrame extends JFrame {
    //带滚动条的面板
    private JScrollPane scpDemo1;
    private JScrollPane scpDemo2;
    private JScrollPane scpDemo3;
    private JScrollPane scpDemo4;
    private JScrollPane scpDemo5;

    //标签
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JLabel jl5;
    private JLabel jl6;
    private JLabel jl7;
    private JLabel jl8;
    private JLabel jl9;
    //勾选框
    private JCheckBox jb1;
    private JCheckBox jb2;
    private JCheckBox jb3;
    private JCheckBox jb4;
    private JCheckBox jb5;
    private JCheckBox jb6;
    private JCheckBox jb7;
    private JCheckBox jb10;
    private JCheckBox jb11;

    //文本框
    private JTextField jTextField;
    private JTextField jb_Snum;
    private JTextField jb_Sname;
    private JTextField jb_Ssex;
    private JTextField jb_Sage1;
    private JTextField jb_Sage2;
    private JTextField jb_SClass;
    private JTextField jb_Cnum;
    private JTextField jb_Cname;
    private JTextField jb_Teacher;
    private JTextField jb_Score1;
    private JTextField jb_Score2;

    //表格头
    private JTableHeader jth1;
    private JTableHeader jth2;
    private JTableHeader jth3;
    private JTableHeader jth4;
    private JTableHeader jth5;

    //表格
    private JTable tabDemo1;
    private JTable tabDemo2;
    private JTable tabDemo3;
    private JTable tabDemo4;
    private JTable tabDemo5;

    //按钮
    private JButton btnShow1;
    private JButton btnShow2;
    private JButton btnShow3;
    private JButton btnShow4;
    private JButton btnShow5;
    private JButton btnShow6;

    private JButton btExit;

    private JComboBox comboBox;

    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DatabaseStatisticsFrame() {
        super("学生表");        //JFrame的标题名称
        this.setSize(1800, 1200);        //控制窗体大小
        this.setLayout(null);        //自定义布局
        this.setLocation(0, 0);    //点击运行以后，窗体在屏幕的位置

        this.scpDemo1 = new JScrollPane();
        this.scpDemo2 = new JScrollPane();
        this.scpDemo3 = new JScrollPane();
        this.scpDemo4 = new JScrollPane();
        this.scpDemo5 = new JScrollPane();

        this.jl1 = new JLabel("表1：student");
        this.jl2 = new JLabel("表2：course");
        this.jl3 = new JLabel("表3：sc");
        this.jl4 = new JLabel("结果");
        this.jl5 = new JLabel("输入SQL语句");
        this.jl6 = new JLabel("检索条件");
        this.jl7 = new JLabel("到");
        this.jl8 = new JLabel("表：");
        this.jl9 = new JLabel("到");

        this.jb1 = new JCheckBox("学号");
        this.jb2 = new JCheckBox("姓名");
        this.jb3 = new JCheckBox("性别");
        this.jb4 = new JCheckBox("年龄");
        this.jb5 = new JCheckBox("班级");
        this.jb6 = new JCheckBox("课号");
        this.jb7 = new JCheckBox("课程名");
        this.jb10 = new JCheckBox("老师");
        this.jb11 = new JCheckBox("成绩");


        this.jb_Snum = new JTextField();
        this.jb_Sname = new JTextField();
        this.jb_Ssex = new JTextField();
        this.jb_Sage1 = new JTextField();
        this.jb_Sage2 = new JTextField();
        this.jb_SClass = new JTextField();
        this.jb_Cname = new JTextField();
        this.jb_Cnum = new JTextField();
        this.jb_Teacher = new JTextField();
        this.jb_Score1 = new JTextField();
        this.jb_Score2 = new JTextField();

        this.comboBox = new JComboBox<>();
        comboBox.addItem("student");
        comboBox.addItem("course");
        comboBox.addItem("sc");
        comboBox.setBounds(100, 760, 120, 30);

        this.jb1.setBounds(620, 60, 60, 30);
        this.jb2.setBounds(850, 60, 60, 30);
        this.jb3.setBounds(620, 100, 60, 30);
        this.jb4.setBounds(620, 140, 60, 30);
        this.jb5.setBounds(850, 100, 60, 30);
        this.jb6.setBounds(620, 180, 60, 30);
        this.jb7.setBounds(850, 180, 60, 30);
        this.jb10.setBounds(620, 220, 60, 30);
        this.jb11.setBounds(620, 260, 60, 30);

        this.jb_Snum.setBounds(680, 60, 120, 30);
        this.jb_Sname.setBounds(900, 60, 120, 30);
        this.jb_Ssex.setBounds(680, 100, 120, 30);
        this.jb_Sage1.setBounds(680, 140, 120, 30);
        this.jb_Sage2.setBounds(830, 140, 120, 30);
        this.jb_SClass.setBounds(900, 100, 120, 30);
        this.jb_Cnum.setBounds(680,180,120,30);
        this.jb_Cname.setBounds(910, 180, 120, 30);
        this.jb_Teacher.setBounds(680, 220, 120, 30);
        this.jb_Score1.setBounds(680, 260, 120, 30);
        this.jb_Score2.setBounds(830, 260, 120, 30);


        this.jl1.setBounds(50, 10, 120, 30);
        this.jl2.setBounds(50, 260, 120, 30);
        this.jl3.setBounds(50, 510, 120, 30);
        this.jl4.setBounds(620, 550, 120, 30);
        this.jl5.setBounds(620, 300, 120, 30);
        this.jl6.setBounds(620, 10, 120, 30);
        this.jl7.setBounds(810, 140, 30, 30);
        this.jl8.setBounds(50, 760, 120, 30);
        this.jl9.setBounds(810, 260, 30, 30);

        this.jl1.setFont(new Font("黑体", Font.PLAIN, 20));
        this.jl2.setFont(new Font("黑体", Font.PLAIN, 20));
        this.jl3.setFont(new Font("黑体", Font.PLAIN, 20));
        this.jl4.setFont(new Font("黑体", Font.PLAIN, 20));
        this.jl5.setFont(new Font("黑体", Font.PLAIN, 20));
        this.jl6.setFont(new Font("黑体", Font.PLAIN, 20));
        this.jl7.setFont(new Font("黑体", Font.PLAIN, 20));
        this.jl8.setFont(new Font("黑体", Font.PLAIN, 20));
        this.jl9.setFont(new Font("黑体", Font.PLAIN, 20));
        this.jl4.setForeground(Color.red);
        this.jl5.setForeground(Color.red);

        this.jTextField = new JTextField();
        this.jTextField.setBounds(610, 340, 700, 200);

        this.btExit = new JButton("退出");

        this.btnShow1 = new JButton("装载");
        this.btnShow2 = new JButton("装载");
        this.btnShow3 = new JButton("装载");
        this.btnShow4 = new JButton("执行SQL语句");
        this.btnShow5 = new JButton("构造SQL语句");
        this.btnShow6 = new JButton("装载");

        this.btExit.setBounds(1000, 10, 100, 30);
        this.scpDemo1.setBounds(10, 50, 350, 200);    //设置滚动框大小
        this.scpDemo2.setBounds(10, 300, 350, 200);    //设置滚动框大小
        this.scpDemo3.setBounds(10, 550, 350, 200);    //设置滚动框大小
        this.scpDemo4.setBounds(610, 590, 700, 200);    //设置滚动框大小
        this.scpDemo5.setBounds(10, 800, 350, 200);

        this.btnShow1.setBounds(240, 10, 120, 30);    //设置装载按钮
        this.btnShow2.setBounds(240, 260, 120, 30);    //设置装载按钮
        this.btnShow3.setBounds(240, 510, 120, 30);    //设置装载按钮
        this.btnShow4.setBounds(1400, 360, 100, 120);    //设置SQL按钮
        this.btnShow5.setBounds(1400, 100, 100, 120);    //设置SQL按钮
        this.btnShow6.setBounds(240, 760, 120, 30);    //设置装载按钮

        this.btnShow1.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                btnShow1_ActionPerformed(ae, "student");
            }
        });
        this.btnShow2.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                btnShow2_ActionPerformed(ae, "course");
            }
        });
        this.btnShow3.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                btnShow3_ActionPerformed(ae, "sc");
            }
        });
        this.btnShow4.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                executeSQL_ActionPerformed(ae);
            }
        });
        this.btnShow5.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                generateSQL_ActionPerformed(ae);
            }
        });
        this.btnShow6.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                btnShow6_ActionPerformed(ae);
            }
        });
        /********按钮“退出”的响应*******/
        this.btExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeSQL_ActionPerformed(e);
                //System.exit(0);
            }
        });

        /******* 将组件加入到窗体中******/
        add(this.scpDemo1);
        add(this.scpDemo2);
        add(this.scpDemo3);
        add(this.scpDemo4);
        add(this.scpDemo5);
        add(this.jb1);
        add(this.jb2);
        add(this.jb3);
        add(this.jb4);
        add(this.jb5);
        add(this.jb6);
        add(this.jb7);
        add(this.jb10);
        add(this.jb11);
        add(this.jb_Sname);
        add(this.jb_Snum);
        add(this.jb_Ssex);
        add(this.jb_Sage1);
        add(this.jb_Sage2);
        add(this.jb_SClass);
        add(this.jb_Cnum);
        add(this.jb_Cname);
        add(this.jb_Score1);
        add(this.jb_Score2);
        add(this.jb_Teacher);
        add(this.jl1);
        add(this.jl2);
        add(this.jl3);
        add(this.jl4);
        add(this.jl5);
        add(this.jl6);
        add(this.jl7);
        add(this.jl8);
        add(this.jl9);
        add(this.jTextField);
        add(this.btnShow1);
        add(this.btnShow2);
        add(this.btnShow3);
        add(this.btnShow4);
        add(this.btnShow5);
        add(this.btnShow6);
        add(this.comboBox);
        add(this.btExit);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DatabaseStatisticsFrame();
    }

    /***连接数据库并显示到表格中***/
    public void btnShow1_ActionPerformed(ActionEvent ae, String table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sct";//注意设置时区
            String username = "root";
            String passwords = "root";
            Connection conn = DriverManager.getConnection(url, username, passwords);
            String sql = "select * from " + table;
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            int count = 0;
            while (rs.next()) {
                count++;
            }
            rs = pstm.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] info = new Object[count][5];
            String[] title = {"学号", "姓名", "性别", "年龄", "班级"};
            count = 0;
            while (rs.next()) {
                info[count][0] = rs.getString("Snum");
                info[count][1] = rs.getString("Sname");
                info[count][2] = rs.getString("Ssex");
                info[count][3] = rs.getInt("Sage");
                info[count][4] = rs.getString("SClass");
                count++;
            }
            // 创建JTable
            this.tabDemo1 = new JTable(info, title);
            // 显示表头
            this.jth1 = this.tabDemo1.getTableHeader();
            // 将JTable加入到带滚动条的面板中
            this.scpDemo1.getViewport().add(tabDemo1);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }   //装载表1

    public void btnShow2_ActionPerformed(ActionEvent ae, String table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sct";//注意设置时区
            String username = "root";
            String passwords = "root";
            Connection conn = DriverManager.getConnection(url, username, passwords);
            String sql = "select * from " + table;
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            int count = 0;
            while (rs.next()) {
                count++;
            }
            rs = pstm.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] info = new Object[count][5];
            String[] title = {"课号", "课程名", "学分", "课时", "老师"};
            count = 0;
            while (rs.next()) {
                info[count][0] = rs.getString("Cnum");
                info[count][1] = rs.getString("Cname");
                info[count][2] = Float.valueOf(rs.getFloat("Credit"));
                info[count][3] = Integer.valueOf(rs.getInt("Chours"));
                info[count][4] = rs.getString("Tnum");
                count++;
            }
            // 创建JTable
            this.tabDemo2 = new JTable(info, title);
            // 显示表头
            this.jth2 = this.tabDemo2.getTableHeader();
            // 将JTable加入到带滚动条的面板中
            this.scpDemo2.getViewport().add(tabDemo2);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }   //装载表2

    public void btnShow3_ActionPerformed(ActionEvent ae, String table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sct";//注意设置时区
            String username = "root";
            String passwords = "root";
            Connection conn = DriverManager.getConnection(url, username, passwords);
            String sql = "select * from " + table;
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            int count = 0;
            while (rs.next()) {
                count++;
            }
            rs = pstm.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] info = new Object[count][5];
            String[] title = {"学号", "课号", "成绩"};
            count = 0;
            while (rs.next()) {
                info[count][0] = rs.getString("Snum");
                info[count][1] = rs.getString("Cnum");
                info[count][2] = Float.valueOf(rs.getFloat("Score"));
                count++;
            }
            // 创建JTable
            this.tabDemo3 = new JTable(info, title);
            // 显示表头
            this.jth3 = this.tabDemo3.getTableHeader();
            // 将JTable加入到带滚动条的面板中
            this.scpDemo3.getViewport().add(tabDemo3);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }   //装载表3

    public void btnShow6_ActionPerformed(ActionEvent ae) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sct";//注意设置时区
            String username = "root";
            String passwords = "root";
            Connection conn = DriverManager.getConnection(url, username, passwords);
            String table = (String)this.comboBox.getSelectedItem();
            String sql = "select * from " + table;
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            int count = 0;
            while (rs.next()) {
                count++;
            }
            rs = pstm.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] info = new Object[count][5];
            String[] title = new String[5];
            switch (table){
                case "student":{
                    String[] title1 = {"学号", "姓名", "性别", "年龄", "班级"};
                    title = title1;
                    for(int i=0;i<5;i++){
                        title[i]="学号";
                    }
                    count = 0;
                    while (rs.next()) {
                        info[count][0] = rs.getString("Snum");
                        info[count][1] = rs.getString("Sname");
                        info[count][2] = rs.getString("Ssex");
                        info[count][3] = Integer.valueOf(rs.getInt("Sage"));
                        info[count][4] = rs.getString("SClass");
                        count++;
                    }
                    break;
                }
                case "course":{
                    String[] title1 = {"课号", "课程名", "学分", "课时", "老师"};
                    title = title1;
                    count = 0;
                    while (rs.next()) {
                        info[count][0] = rs.getString("Cnum");
                        info[count][1] = rs.getString("Cname");
                        info[count][2] = Float.valueOf(rs.getFloat("Credit"));
                        info[count][3] = Integer.valueOf(rs.getInt("Chours"));
                        info[count][4] = rs.getString("Tnum");
                        count++;
                    }
                    break;
                }
                case "sc":{
                    String[] title1 = {"学号", "课号", "成绩"};
                    title = title1;
                    count = 0;
                    while (rs.next()) {
                        info[count][0] = rs.getString("Snum");
                        info[count][1] = rs.getString("Cnum");
                        info[count][2] = Float.valueOf(rs.getFloat("Score"));
                        count++;
                    }
                    break;
                }
            }

            // 创建JTable
            this.tabDemo5 = new JTable(info, title);
            // 显示表头
            this.jth5 = this.tabDemo5.getTableHeader();
            // 将JTable加入到带滚动条的面板中
            this.scpDemo5.getViewport().add(tabDemo5);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }   //装载表

    public void executeSQL_ActionPerformed(ActionEvent ae) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sct";//注意设置时区
            String username = "root";
            String passwords = "root";
            Connection conn = DriverManager.getConnection(url, username, passwords);

            String sql = this.jTextField.getText();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = 0;
            while (rs.next()) {
                count++;
            }
            Object[][] info = new Object[count][rsmd.getColumnCount()];
            String[] title = new String[rsmd.getColumnCount()];
            for (int i = 0; i < title.length; i++) {
                title[i] = rsmd.getColumnName(i + 1);
            }
            rs = pstm.executeQuery();
            count = 0;
            while (rs.next()) {
                for (int j = 0; j < rsmd.getColumnCount(); j++) {
                    info[count][j] = rs.getString(title[j]);
                }
                count++;
            }
            // 创建JTable
            this.tabDemo4 = new JTable(info, title);
            // 显示表头
            this.jth4 = this.tabDemo4.getTableHeader();
            // 将JTable加入到带滚动条的面板中
            this.scpDemo4.getViewport().add(tabDemo4);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, cnfe.getCause() + ":数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            sqle.printStackTrace();

            JOptionPane.showMessageDialog(null, sqle.getErrorCode() + ":数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }   //执行sql语句

    public void generateSQL_ActionPerformed(ActionEvent ae) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sct";//注意设置时区
            String username = "root";
            String passwords = "root";
            Connection conn = DriverManager.getConnection(url, username, passwords);
            boolean[] flag = new boolean[9];
            if (jb1.isSelected())
                flag[0] = true;
            else
                flag[0] = false;
            if (jb2.isSelected())
                flag[1] = true;
            else
                flag[1] = false;
            if (jb3.isSelected())
                flag[2] = true;
            else
                flag[2] = false;
            if (jb4.isSelected())
                flag[3] = true;
            else
                flag[3] = false;
            if (jb5.isSelected())
                flag[4] = true;
            else
                flag[4] = false;
            if (jb6.isSelected())
                flag[5] = true;
            else
                flag[5] = false;
            if (jb7.isSelected())
                flag[6] = true;
            else
                flag[6] = false;
            if (jb10.isSelected())
                flag[7] = true;
            else
                flag[7] = false;
            if (jb11.isSelected())
                flag[8] = true;
            else
                flag[8] = false;
            int sum = 0;
            int s1=0,s2=0,s3=0;
            for(int j=0;j<5;j++){
                if (flag[j] == true)
                    s1=1;
            }
            for(int j=5;j<8;j++){
                if (flag[j] == true)
                    s2=1;
            }
            for(int j=8;j<9;j++){
                if (flag[j] == true)
                    s3=1;
            }
            sum=s1+s2+s3;
            String sql = "";
            switch (sum){
                case 0:
                case 3:{
                    sql = "select * from student,course,sc ";
                    break;
                }
                case 1:{
                    if(s1>0){
                        sql = "select * from student ";
                    }
                    else if(s2>0){
                        sql = "select * from course ";
                    }
                    else{
                        sql = "select * from sc ";
                    }
                    break;
                }
                case 2:{
                    if(s1==0){
                        sql = "select * from course,sc ";
                    }
                    else if(s2==0){
                        sql = "select * from student,sc ";
                    }
                    else{
                        sql = "select * from student,course ";
                    }
                    break;
                }
            }
            if (sum > 0) {
                sql += "where ";
            }
            sum = 0;
            if (flag[0] == true) {
                sql += "student.Snum like " + "\"" + jb_Snum.getText() + "\"";
                sum++;
            }
            if (flag[1] == true) {
                if (sum > 0)
                    sql += " && ";
                sql += " Sname like " + "\"" + jb_Sname.getText() + "\"";
                sum++;
            }
            if (flag[2] == true) {
                if (sum > 0)
                    sql += " && ";
                sql += " Ssex = " + "\"" + jb_Ssex.getText() + "\"";
                sum++;
            }
            if (flag[3] == true) {
                if (sum > 0)
                    sql += " && ";
                sql += jb_Sage1.getText() + " <= Sage && Sage <= " + jb_Sage2.getText();
                sum++;
            }
            if (flag[4] == true) {
                if (sum > 0)
                    sql += " && ";
                sql += "SClass = " + jb_SClass.getText();
                sum++;
            }
            if (flag[5] == true) {
                if (sum > 0)
                    sql += " && ";
                sql += "course.Cnum like " + "\"" + jb_Cnum.getText() + "\"";
                sum++;
            }
            if (flag[6] == true) {
                if (sum > 0)
                    sql += " && ";
                sql += " Cname like " + "\"" + jb_Cname.getText() + "\"";
                sum++;
            }
            if (flag[7] == true) {
                if (sum > 0)
                    sql += " && ";
                sql += " Tnum like " + "\"" + jb_Teacher.getText() + "\"";
                sum++;
            }
            if (flag[8] == true) {
                if (sum > 0)
                    sql += " && ";
                sql += jb_Score1.getText() + " <= Score && Score <= " + jb_Score2.getText();
                if(s1>0){
                    sql+=" && sc.Snum=student.Snum ";
                }
                if(s2>0){
                    sql+=" && sc.Cnum=course.Cnum ";
                }
                sum++;
            }

            if (sum == 0)
                sql = "select * from student,course,sc limit 100";
            else
                sql+=" limit 100";
            jTextField.setText(sql);
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = 0;
            while (rs.next()) {
                count++;
            }
            Object[][] info = new Object[count][rsmd.getColumnCount()];
            String[] title = new String[rsmd.getColumnCount()];
            for (int i = 0; i < title.length; i++) {
                title[i] = rsmd.getColumnName(i + 1);
            }
            rs = pstm.executeQuery();
            count = 0;
            while (rs.next()) {
                for (int j = 0; j < rsmd.getColumnCount(); j++) {
                    info[count][j] = rs.getString(title[j]);
                }
                count++;
            }
            // 创建JTable
            this.tabDemo4 = new JTable(info, title);
            // 显示表头
            this.jth4 = this.tabDemo4.getTableHeader();
            // 将JTable加入到带滚动条的面板中
            this.scpDemo4.getViewport().add(tabDemo4);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, cnfe.getCause() + ":数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            sqle.printStackTrace();

            JOptionPane.showMessageDialog(null, sqle.getErrorCode() + ":数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }   //生成sql语句

    public void databaseDictionary_ActionPerformed(ActionEvent ae) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sct";//注意设置时区
            String username = "root";
            String passwords = "root";
            Connection conn = DriverManager.getConnection(url, username, passwords);
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet tableResultSet = dbmd.getTables(null, null, null, new String[]{"TABLE"});
            while (tableResultSet.next()) {
                String tableName = tableResultSet.getString("TABLE_NAME");
                System.out.println("table:" + tableName);

                // 获取表字段结构
                ResultSet columnResultSet = dbmd.getColumns(null, "%", tableName, "%");
                while (columnResultSet.next()) {
                    // 字段名称
                    String columnName = columnResultSet.getString("COLUMN_NAME");
                    String sql = "select * from " + columnName;
                }
            }

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, cnfe.getCause() + ":数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            sqle.printStackTrace();

            JOptionPane.showMessageDialog(null, sqle.getErrorCode() + ":数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}


