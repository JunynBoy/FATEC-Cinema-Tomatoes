/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package janelas;

import app.models.Filme;
import app.models.Genero;
import app.models.FilmeTableModel;
import app.models.Usuario;
import app.services.FilmeService;
import app.services.GeneroService;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class Principal extends javax.swing.JFrame {

    private boolean logado = false;
    public static Usuario usuario = new Usuario();
    public FilmeService filmeService = new FilmeService();
    public GeneroService generoService = new GeneroService();
    public FilmeTableModel filmeTableModel = new FilmeTableModel();
    public LinkedList<Filme> filmes = new LinkedList();
    public Filme filmeSelecionado = new Filme();
    public LinkedList<Genero> generos = new LinkedList();
    
    
    
    public Principal() {
        initComponents();
        this.centralizarComponente();
        this.miLogOut.setVisible(logado);
        this.jifListarFilme.setVisible(false);
        this.loadTable();
        this.jmFilme.setVisible(false);
        this.atualizarFilmes();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jifListarFilme = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFilme = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNomeFilter = new javax.swing.JTextField();
        javax.swing.JButton btnBuscar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmUsuario = new javax.swing.JMenu();
        miLogin = new javax.swing.JMenuItem();
        miCadastro = new javax.swing.JCheckBoxMenuItem();
        miLogOut = new javax.swing.JMenuItem();
        jmFilme = new javax.swing.JMenu();
        miListarFilmes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(840, 480));
        setMinimumSize(new java.awt.Dimension(840, 480));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jifListarFilme.setClosable(true);
        jifListarFilme.setEnabled(false);
        jifListarFilme.setVisible(true);
        jifListarFilme.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jifListarFilmeComponentShown(evt);
            }
        });

        jTFilme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTFilme);

        jLabel1.setText("Filtrar Por nome:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblHeader.setText("Lista de filmes Cinema Tomatoes");
        lblHeader.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jifListarFilmeLayout = new javax.swing.GroupLayout(jifListarFilme.getContentPane());
        jifListarFilme.getContentPane().setLayout(jifListarFilmeLayout);
        jifListarFilmeLayout.setHorizontalGroup(
            jifListarFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifListarFilmeLayout.createSequentialGroup()
                .addGroup(jifListarFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jifListarFilmeLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jifListarFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jifListarFilmeLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jifListarFilmeLayout.setVerticalGroup(
            jifListarFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jifListarFilmeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jifListarFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(30, 30, 30)
                .addGroup(jifListarFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jifListarFilmeLayout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)))
                .addContainerGap())
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jmUsuario.setText("Usuario");

        miLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miLogin.setText("Login");
        miLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLoginActionPerformed(evt);
            }
        });
        jmUsuario.add(miLogin);

        miCadastro.setSelected(true);
        miCadastro.setText("Cadastro");
        miCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroActionPerformed(evt);
            }
        });
        jmUsuario.add(miCadastro);

        miLogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miLogOut.setText("Log Out");
        miLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogOutActionPerformed(evt);
            }
        });
        jmUsuario.add(miLogOut);

        jMenuBar1.add(jmUsuario);

        jmFilme.setText("Filme");

        miListarFilmes.setText("ListarFilmes");
        miListarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListarFilmesActionPerformed(evt);
            }
        });
        jmFilme.add(miListarFilmes);

        jMenuBar1.add(jmFilme);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jifListarFilme)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jifListarFilme)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLoginActionPerformed
        
        LoginDialog loginDialog = new LoginDialog( this ,true, true,
                this.logado ,this.usuario);
        loginDialog.setVisible(rootPaneCheckingEnabled);
        this.usuario = loginDialog.getUsuario();
        if(usuario != null && usuario.getId() != 0){
            this.logado = true;
            this.validarEstadoUsuario();
        }
        
    }//GEN-LAST:event_miLoginActionPerformed

    private void miCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroActionPerformed

        LoginDialog loginModal = new LoginDialog( this ,true, false, this.logado, this.usuario);
        loginModal.setVisible(rootPaneCheckingEnabled);
                
    }//GEN-LAST:event_miCadastroActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
        System.out.println("teste login");
        if(usuario != null){
            System.out.println(this.usuario.getNome());
        }
        
        
    }//GEN-LAST:event_formWindowActivated

    private void miLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogOutActionPerformed
       
        this.usuario = null;
        this.logado = false;
        this.jmFilme.setVisible(logado);
        this.jifListarFilme.setVisible(false);
        JOptionPane.showMessageDialog(this, "LogOut Finalizado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        this.validarEstadoUsuario();
        
    }//GEN-LAST:event_miLogOutActionPerformed

    private void miListarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListarFilmesActionPerformed
        
        this.jifListarFilme.setVisible(true);
        
        
    }//GEN-LAST:event_miListarFilmesActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
       String titulo = this.txtNomeFilter.getText() != null ? this.txtNomeFilter.getText() : null;

       this.filmes = this.filmeService.getAllByTitulo(titulo);

       this.filmeTableModel.removeAllRows();
       this.filmeTableModel.addRows(this.filmes);
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        FilmeFrame filmeDialog = new FilmeFrame(this,false, this.usuario);
        filmeDialog.setVisible(true);
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jifListarFilmeComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jifListarFilmeComponentShown
        //FAZER O METODO DE INICIAR TABELA
        
    }//GEN-LAST:event_jifListarFilmeComponentShown

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
       
        try {
            filmeSelecionado = this.obterFilmeSelecionado();
            if(filmeSelecionado == null){
                throw new Exception("Erro, objeto nao selecionado");
            }else{
                FilmeFrame filmeDialog = new FilmeFrame(this,true, filmeSelecionado, this.usuario);
                filmeDialog.setVisible(true);
            }
                
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Selecione um valor e tente novamente ", "Nenhum filme selecionado", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    private void loadServices() {
        this.generos = this.generoService.getAll();
        this.filmes = this.filmeService.getAll();
    }
    
    public void loadTable(){
        jTFilme.setModel(filmeTableModel);
        jTFilme.getColumnModel().getColumn(0).setMinWidth(0);
        jTFilme.getColumnModel().getColumn(0).setMaxWidth(0);
        jTFilme.getColumnModel().getColumn(0).setWidth(0);
    }
    
    public void centralizarComponente() { 
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = getSize(); setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
    }
    
    public void validarEstadoUsuario(){
        if(this.usuario == null | this.logado == false){
            this.jmUsuario.setText("Usuario");
            this.miLogOut.setVisible(false);
            this.miCadastro.setVisible(true);
            this.miLogin.setVisible(true);
        }else{
            this.jmUsuario.setText(usuario.getNome());
            this.miLogOut.setVisible(true);
            this.miCadastro.setVisible(false);
            this.miLogin.setVisible(false);
            this.jmFilme.setVisible(true);
        }
    }
    
    
    public void atualizarFilmes() {                                          
        
       this.txtNomeFilter.setText("");
       this.filmes = this.filmeService.getAll();
       this.filmeTableModel.removeAllRows();
       this.filmeTableModel.addRows(this.filmes);
        
    } 
    
    
    
    
    private Filme obterFilmeSelecionado(){
        
        int linhaSelecionada = jTFilme.getSelectedRow();

        if (linhaSelecionada != -1) {
            int valorCelula = (int) jTFilme.getValueAt(linhaSelecionada, 0);
            
            if (valorCelula > 0) {
                return filmeService.getbyId(valorCelula);
            }

        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTFilme;
    private javax.swing.JInternalFrame jifListarFilme;
    private javax.swing.JMenu jmFilme;
    private javax.swing.JMenu jmUsuario;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JCheckBoxMenuItem miCadastro;
    private javax.swing.JMenuItem miListarFilmes;
    private javax.swing.JMenuItem miLogOut;
    private javax.swing.JMenuItem miLogin;
    private javax.swing.JTextField txtNomeFilter;
    // End of variables declaration//GEN-END:variables
}
