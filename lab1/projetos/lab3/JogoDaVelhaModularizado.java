package lab3;

/*Aluno 1: Adenou dantas de Farias Júnior*/
/*Aluno 2: Joyce Mikaella das Mercês Aciole*/
/*Aluno 3: Wanderson Messíades Leal*/


import javax.swing.JOptionPane;

public class JogoDaVelhaModularizado extends javax.swing.JFrame {

boolean Jogador1Ativo = true;
boolean Jogador2Ativo = false;

int VitoriaDoJogador1 = 0;
int VitoriaDoJogador2 = 0;
int PartidasEmpatadas = 0;

public JogoDaVelhaModularizado() {
    initComponents();
}

public void JogadorAtivo(){
    
    if (Jogador1Ativo == true) {
        Jogador1Ativo = false;
        Jogador2Ativo = true;
    } else {
        Jogador1Ativo = true;
        Jogador2Ativo = false;
    }
    
    JogadorVencedor("X");
    JogadorVencedor("O");
    
}


 public void JogadorVencedor(String Jogador) {
    
    
    /******************* Verificando Linhas *********************/
    if (B1.getText().equals(Jogador) &&
            B2.getText().equals(Jogador) &&
            B3.getText().equals(Jogador)) {
        
        if (B1.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
        
    }
    
    
    if (B4.getText().equals(Jogador) &&
            B5.getText().equals(Jogador) &&
            B6.getText().equals(Jogador)) {
        
        if (B4.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
        
    }
    
    
    if (B7.getText().equals(Jogador) &&
            B8.getText().equals(Jogador) &&
            B9.getText().equals(Jogador)) {
        
        if (B7.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
        
    }
    
    
    /******************* Verificando Colunas *********************/
    if (B1.getText().equals(Jogador) &&
            B4.getText().equals(Jogador) &&
            B7.getText().equals(Jogador)) {
        
        if (B1.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
        
    }
    
    
    if (B2.getText().equals(Jogador) &&
            B5.getText().equals(Jogador) &&
            B8.getText().equals(Jogador)) {
        
        if (B2.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
        
    }
    
    
    if (B3.getText().equals(Jogador) &&
            B6.getText().equals(Jogador) &&
            B9.getText().equals(Jogador)) {
        
        if (B3.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
        
    }
    
    
    /******************* Verificando Diagonais *********************/
    if (B1.getText().equals(Jogador) &&
            B5.getText().equals(Jogador) &&
            B9.getText().equals(Jogador)) {
        
        if (B1.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
        
    }
    
    
    if (B3.getText().equals(Jogador) &&
            B5.getText().equals(Jogador) &&
            B7.getText().equals(Jogador)) {
        
        if (B3.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
        
    }
    
    
    /******************* Verificando Empate *********************/
    if ( !B1.getText().equals("") &&
            !B2.getText().equals("") &&
            !B3.getText().equals("") &&
            !B4.getText().equals("") &&
            !B5.getText().equals("") &&
            !B6.getText().equals("") &&
            !B7.getText().equals("") &&
            !B8.getText().equals("") &&
            !B9.getText().equals("") ) {
        
        Vencedor("Empate");
    }
    
}
 
   public void Vencedor(String JogadorVencedor) {
    
    if (JogadorVencedor.equals("Jogador 1")) {
        JOptionPane.showMessageDialog(JogoDaVelhaModularizado.this, "Parabéns Jogador 1. Você venceu o Jogo!");
        VitoriaDoJogador1++;
        
        NumeroDeVitoriasDoJogador1.setText("Número de Vitórias: " + VitoriaDoJogador1);
        LimparCampos();
    }
    
    
    if (JogadorVencedor.equals("Jogador 2")) {
        JOptionPane.showMessageDialog(JogoDaVelhaModularizado.this, "Parabéns Jogador 2. Você venceu o Jogo!");
        VitoriaDoJogador2++;
        NumeroDeVitoriasDoJogador2.setText("Número de Vitórias: " + VitoriaDoJogador2);
        LimparCampos();
    }
    
    
    if (JogadorVencedor.equals("Empate")) {
        JOptionPane.showMessageDialog(JogoDaVelhaModularizado.this, "Jogo Empatado! Joguem Novamente!");
        PartidasEmpatadas++;
        NumeroDeEmpates.setText("Número de Empates: " + PartidasEmpatadas);
        LimparCampos();
    }
    
}


public void LimparCampos() {
    
    B1.setText("");
    B2.setText("");
    B3.setText("");
    B4.setText("");
    B5.setText("");
    B6.setText("");
    B7.setText("");
    B8.setText("");
    B9.setText("");
    
    Jogador1Ativo = true;
    Jogador2Ativo = false;
    
}

public void LimparPlacar(){
    VitoriaDoJogador1 = 0;
    VitoriaDoJogador2 = 0;
    PartidasEmpatadas = 0;
    NumeroDeVitoriasDoJogador1.setText("Número de Vitórias: " + VitoriaDoJogador1);
    NumeroDeVitoriasDoJogador2.setText("Número de Vitórias: " + VitoriaDoJogador2);
    NumeroDeEmpates.setText("Número de Empates: " + PartidasEmpatadas);
    
    
     
   
    
}




@SuppressWarnings("unchecked")
                          
private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    B1 = new javax.swing.JButton();
    B2 = new javax.swing.JButton();
    B3 = new javax.swing.JButton();
    B4 = new javax.swing.JButton();
    B5 = new javax.swing.JButton();
    B6 = new javax.swing.JButton();
    B7 = new javax.swing.JButton();
    B8 = new javax.swing.JButton();
    B9 = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    NumeroDeVitoriasDoJogador1 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    NumeroDeVitoriasDoJogador2 = new javax.swing.JLabel();
    jSeparator2 = new javax.swing.JSeparator();
    NumeroDeEmpates = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    NovoJogo = new javax.swing.JButton();
    SairDoJogo = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Jogo da Velha");
    setResizable(false);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jogo da Velha", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

    B1.setFont(new java.awt.Font("Tahoma", 0, 40)); 
    B1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            B1ActionPerformed(evt);
        }
    });

    B2.setFont(new java.awt.Font("Tahoma", 0, 40)); 
    B2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            B2ActionPerformed(evt);
        }
    });

    B3.setFont(new java.awt.Font("Tahoma", 0, 40)); 
    B3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            B3ActionPerformed(evt);
        }
    });

    B4.setFont(new java.awt.Font("Tahoma", 0, 40)); 
    B4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            B4ActionPerformed(evt);
        }
    });

    B5.setFont(new java.awt.Font("Tahoma", 0, 40)); 
    B5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            B5ActionPerformed(evt);
        }
    });

    B6.setFont(new java.awt.Font("Tahoma", 0, 40)); 
    B6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            B6ActionPerformed(evt);
        }
    });

    B7.setFont(new java.awt.Font("Tahoma", 0, 40)); 
    B7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            B7ActionPerformed(evt);
        }
    });

    B8.setFont(new java.awt.Font("Tahoma", 0, 40)); 
    B8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            B8ActionPerformed(evt);
        }
    });

    B9.setFont(new java.awt.Font("Tahoma", 0, 40)); 
    B9.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            B9ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(B2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(B3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(B4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(B7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B9))))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {B1, B2, B3, B4, B5, B6, B7, B8, B9});

    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(4, 4, 4)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(B3))
            .addGap(4, 4, 4)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(B5)
                .addComponent(B4)
                .addComponent(B6))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(B8)
                .addComponent(B7)
                .addComponent(B9))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {B1, B2, B3, B4, B5, B6, B7, B8, B9});

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

    jLabel1.setText("Jogador 1   Simbolo: X");

    jLabel2.setText("Jogador 2   Simbolo: O");

    NumeroDeVitoriasDoJogador1.setText("Número de Vitórias: 0");

    NumeroDeVitoriasDoJogador2.setText("Número de Vitórias: 0");

    NumeroDeEmpates.setText("Número de Empates: 0");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jSeparator1)
        .addComponent(jSeparator2)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(NumeroDeVitoriasDoJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(NumeroDeVitoriasDoJogador2)
                .addComponent(NumeroDeEmpates))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(1, 1, 1)
            .addComponent(NumeroDeVitoriasDoJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(NumeroDeVitoriasDoJogador2)
            .addGap(18, 18, 18)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(NumeroDeEmpates)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

    NovoJogo.setText("Novo Jogo");
    NovoJogo.setPreferredSize(new java.awt.Dimension(79, 25));
    NovoJogo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            NovoJogoActionPerformed(evt);
        }
    });



    SairDoJogo.setText("Sair do Jogo");
    SairDoJogo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SairDoJogoActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(NovoJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addComponent(SairDoJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(19, Short.MAX_VALUE))
    );

    jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {NovoJogo, SairDoJogo});

    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(9, 9, 9)
            .addComponent(NovoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)       
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(SairDoJogo)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {NovoJogo, SairDoJogo});

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap())
    );

    pack();
}                        

private void B2ActionPerformed(java.awt.event.ActionEvent evt) {                                   
    
    if(Jogador1Ativo == true){
        if(B2.getText().equals("")){
            B2.setText("X");
            JogadorAtivo();
        }
    }else{
        if (B2.getText().equals("")){
            B2.setText("O");
            JogadorAtivo();
        }
    }
    
    
}                                  

private void B3ActionPerformed(java.awt.event.ActionEvent evt) {                                   
    
    if(Jogador1Ativo == true){
        if(B3.getText().equals("")){
            B3.setText("X");
            JogadorAtivo();
        }
    }else{
        if (B3.getText().equals("")){
            B3.setText("O");
            JogadorAtivo();
        }
    }
    
}                                  

private void B1ActionPerformed(java.awt.event.ActionEvent evt) {                                   
    if(Jogador1Ativo == true){
        if(B1.getText().equals("")){
            B1.setText("X");
            JogadorAtivo();
        }
    }else{
        if (B1.getText().equals("")){
            B1.setText("O");
            JogadorAtivo();
        }
    }
}                                  

private void B4ActionPerformed(java.awt.event.ActionEvent evt) {                                   
    if(Jogador1Ativo == true){
        if(B4.getText().equals("")){
            B4.setText("X");
            JogadorAtivo();
        }
    }else{
        if (B4.getText().equals("")){
            B4.setText("O");
            JogadorAtivo();
        }
    }
}                                  

private void B5ActionPerformed(java.awt.event.ActionEvent evt) {                                   
    if(Jogador1Ativo == true){
        if(B5.getText().equals("")){
            B5.setText("X");
            JogadorAtivo();
        }
    }else{
        if (B5.getText().equals("")){
            B5.setText("O");
            JogadorAtivo();
        }
    }
}                                  

private void B6ActionPerformed(java.awt.event.ActionEvent evt) {                                   
    if(Jogador1Ativo == true){
        if(B6.getText().equals("")){
            B6.setText("X");
            JogadorAtivo();
        }
    }else{
        if (B6.getText().equals("")){
            B6.setText("O");
            JogadorAtivo();
        }
    }
}                                  

private void B7ActionPerformed(java.awt.event.ActionEvent evt) {                                   
    if(Jogador1Ativo == true){
        if(B7.getText().equals("")){
            B7.setText("X");
            JogadorAtivo();
        }
    }else{
        if (B7.getText().equals("")){
            B7.setText("O");
            JogadorAtivo();
        }
    }
}                                  

private void B8ActionPerformed(java.awt.event.ActionEvent evt) {                                   
    if(Jogador1Ativo == true){
        if(B8.getText().equals("")){
            B8.setText("X");
            JogadorAtivo();
        }
    }else{
        if (B8.getText().equals("")){
            B8.setText("O");
            JogadorAtivo();
        }
    }
}                                  

private void B9ActionPerformed(java.awt.event.ActionEvent evt) {                                   
    if(Jogador1Ativo == true){
        if(B9.getText().equals("")){
            B9.setText("X");
            JogadorAtivo();
        }
    }else{
        if (B9.getText().equals("")){
            B9.setText("O");
            JogadorAtivo();
        }
    }
}                                  

private void NovoJogoActionPerformed(java.awt.event.ActionEvent evt) {                                         
    
    LimparCampos();
    LimparPlacar();
    
    
    
    
}                                        

private void SairDoJogoActionPerformed(java.awt.event.ActionEvent evt) {                                           
    
    System.exit(0);
    
    
}                                          


public static void main(String args[]) {
    
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(JogoDaVelhaModularizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(JogoDaVelhaModularizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(JogoDaVelhaModularizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(JogoDaVelhaModularizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    

    
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new JogoDaVelhaModularizado().setVisible(true);
        }
    });
}

                     
private javax.swing.JButton B1;
private javax.swing.JButton B2;
private javax.swing.JButton B3;
private javax.swing.JButton B4;
private javax.swing.JButton B5;
private javax.swing.JButton B6;
private javax.swing.JButton B7;
private javax.swing.JButton B8;
private javax.swing.JButton B9;
private javax.swing.JButton NovoJogo;
private javax.swing.JLabel NumeroDeEmpates;
private javax.swing.JLabel NumeroDeVitoriasDoJogador1;
private javax.swing.JLabel NumeroDeVitoriasDoJogador2;
private javax.swing.JButton SairDoJogo;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JPanel jPanel1;
private javax.swing.JPanel jPanel2;
private javax.swing.JPanel jPanel3;
private javax.swing.JSeparator jSeparator1;
private javax.swing.JSeparator jSeparator2;
                  
}

