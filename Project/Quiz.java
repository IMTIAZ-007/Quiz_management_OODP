


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author HP
 */
public class Quiz extends javax.swing.JFrame {

    private String selectedSubject;
    private int timeLeft = 10; // Initial time in seconds
    private Timer timer;
    private int currentQuestionIndex = 0;
    private int score;
    private ResultSet resultSet;
    private JButton nextButton;
    private JButton submitButton;
    private int totalQuestions;
    private String username;
    private boolean isDataSaved = false;

    public Quiz(String username, String selectedCategory1) {
        initComponents();
        this.username = username;
        this.selectedSubject = selectedCategory1;
        loadTotalQuestions();
        currentQuestionIndex = 0;
        loadQuestion();
        
          if (totalQuestions > 0) {
            currentQuestionIndex = 0;
            loadQuestion();

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer.setText(Integer.toString(timeLeft));
                timeLeft--;

                if (timeLeft < 0) {
                    timer.stop();
                    Timer.setText("Time's Up!");
                    option1.setEnabled(false);
                    option2.setEnabled(false);
                    option3.setEnabled(false);
                    option4.setEnabled(false);
                    jButton2.setEnabled(false);
                    resetUIComponents();
                    loadNextQuestion();
                }
            }
        });

        timer.start();
    
           } else {
            
            JOptionPane.showMessageDialog(this, "No questions available for the selected category.");
            this.dispose(); // Close the quiz window
        }}

    private void resetUIComponents() {
        buttonGroup1.clearSelection();
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);
        jButton2.setEnabled(true);
    }

    private void loadTotalQuestions() {
        try {
            java.sql.Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
            String query = "SELECT COUNT(*) FROM questions WHERE sub = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, selectedSubject);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                totalQuestions = result.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading total questions: " + e.getMessage());
        }
    }

    private void loadQuestion() {
        resetUIComponents();
        try {
            java.sql.Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
            String query = "SELECT id, question, option1, option2, option3, option4, answer FROM questions WHERE sub = ? AND id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, selectedSubject);
            ps.setInt(2, currentQuestionIndex + 1);
            
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int questionNumber = resultSet.getInt("id");
                String questionText = resultSet.getString("question");
                String option1Text = resultSet.getString("option1");
                String option2Text = resultSet.getString("option2");
                String option3Text = resultSet.getString("option3");
                String option4Text = resultSet.getString("option4");

                Questionno.setText(" " + questionNumber);
                question.setText(questionText);
                option1.setText(option1Text);
                option2.setText(option2Text);
                option3.setText(option3Text);
                option4.setText(option4Text);
            }
            /*else {
            // No more questions, display final score
            question.setText("Quiz Completed! Your Score: " + score);
            option1.setEnabled(false);
            option2.setEnabled(false);
            option3.setEnabled(false);
            option4.setEnabled(false);
        }*/
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading question: " + e.getMessage());
        }
    }

    private void loadNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < totalQuestions) {
            timeLeft = 10;
            timer.start();
            loadQuestion();
        } else {
            timer.stop();
            showScore();
        }
    }

    private void checkAnswer(String selectedAnswer) {
        try {
            String correctAnswer = resultSet.getString("answer");
            if (correctAnswer.equals(selectedAnswer)) {
                score++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error checking answer: " + e.getMessage());
        }
    }

    private void showScore() {
         if (!isDataSaved) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        String dateTime = dateFormat.format(date);
        StudentDashboard st = new StudentDashboard(username);
        saveDataToDatabase(username,selectedSubject, score, dateTime);
        isDataSaved = true;
         }

        jTextField1.setText(username);
        //jLabel7.setText(name.getText());
        jLabel8.setText(String.valueOf(score));

        // JOptionPane.showMessageDialog(this, "Quiz Completed!\nWell Done, " + username + "\nYour Score: " + score);
    }

    private void saveDataToDatabase(String username,String selectedSubject, int score, String dateTime) {
        try {
            java.sql.Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
            String sql = "INSERT INTO results (username,sub, score, datetime) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, selectedSubject);
            ps.setInt(3, score);
            ps.setString(4, dateTime);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public int getScore() {
        return score;
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        question = new javax.swing.JLabel();
        Timer = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Questionno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jDialog1.setBackground(new java.awt.Color(51, 153, 255));
        jDialog1.setMinimumSize(new java.awt.Dimension(400, 300));
        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jDialog1.setLocationRelativeTo(null);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(51, 153, 255));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.setFocusable(false);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 110, 40));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/check.png"))); // NOI18N
        jButton3.setText("ok");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 30, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Your Score");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 70, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Well done");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jDialog1.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(option1);
        option1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        option1.setForeground(new java.awt.Color(255, 255, 255));
        option1.setText("option1");
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });
        getContentPane().add(option1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, 160, -1));

        buttonGroup1.add(option2);
        option2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        option2.setForeground(new java.awt.Color(255, 255, 255));
        option2.setText("option2");
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });
        getContentPane().add(option2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 580, 130, -1));

        buttonGroup1.add(option3);
        option3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        option3.setForeground(new java.awt.Color(255, 255, 255));
        option3.setText("option3");
        option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ActionPerformed(evt);
            }
        });
        getContentPane().add(option3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 720, 130, -1));

        buttonGroup1.add(option4);
        option4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        option4.setForeground(new java.awt.Color(255, 255, 255));
        option4.setText("option4");
        option4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ActionPerformed(evt);
            }
        });
        getContentPane().add(option4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 720, 130, -1));

        question.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        question.setForeground(new java.awt.Color(255, 255, 255));
        question.setText("Questions");
        getContentPane().add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 986, -1));

        Timer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Timer.setForeground(new java.awt.Color(255, 51, 51));
        Timer.setText("30");
        getContentPane().add(Timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 200, 37, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/submit.png"))); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 800, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next-button.png"))); // NOI18N
        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 810, -1, -1));

        Questionno.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Questionno.setForeground(new java.awt.Color(255, 255, 255));
        Questionno.setText("No");
        getContentPane().add(Questionno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 40, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1467, 21, 37, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Time:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1127, 200, 80, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quiz Time!!!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 290, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Proofread your answers carefully before you publish your quiz.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 350, 24));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/4.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -270, 1570, 1260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        // TODO add your handling code here:
        checkAnswer(option1.getText());


    }//GEN-LAST:event_option1ActionPerformed

    private void option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ActionPerformed
        // TODO add your handling code here:
        checkAnswer(option3.getText());


    }//GEN-LAST:event_option3ActionPerformed

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        // TODO add your handling code here:
        checkAnswer(option2.getText());


    }//GEN-LAST:event_option2ActionPerformed

    private void option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ActionPerformed
        // TODO add your handling code here:
        checkAnswer(option4.getText());


    }//GEN-LAST:event_option4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        showScore();
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
        jButton2.setEnabled(false);
        StudentDashboard s = new StudentDashboard(username);
        s.setVisible(true);
        jDialog1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        buttonGroup1.clearSelection();
        if (timeLeft >= 0) {
            timer.start();
            loadNextQuestion();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jDialog1.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Quiz q = new Quiz("username", "SelectedCategory1");
                q.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Questionno;
    private javax.swing.JLabel Timer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.JLabel question;
    // End of variables declaration//GEN-END:variables
}
