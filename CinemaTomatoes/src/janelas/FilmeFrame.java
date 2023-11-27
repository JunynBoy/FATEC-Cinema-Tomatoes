/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package janelas;

import app.models.ComentarioTableModel;
import app.models.Filme;
import app.models.Genero;
import app.models.Comentario;
import app.models.Usuario;
import app.services.ComentarioService;
import app.services.FilmeService;
import app.services.GeneroService;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JuninBoy
 */
public class FilmeFrame extends javax.swing.JFrame {

    private boolean editar = false;
    private Usuario usuarioLogado = new Usuario();
    private FilmeService filmeService = new FilmeService();
    private GeneroService generoService = new GeneroService();
    private ComentarioService comentarioService = new ComentarioService();
    private LinkedList<Genero> comboGenero = new LinkedList<>();
    private LinkedList<Comentario> comentarios = new LinkedList<>();
    private ComentarioTableModel comentarioTableModel = new ComentarioTableModel();
    private Filme filmeSelecionado;
    
    public FilmeFrame(java.awt.Frame parent, boolean editar, Usuario usuarioLogado) {
        initComponents();
        this.centralizarComponente();
        this.editar = editar;
        this.usuarioLogado = usuarioLogado;
        this.jtComentarios.setVisible(false);
        this.loadComboBox();
    }
    
    public FilmeFrame(java.awt.Frame parent, boolean editar, Filme filme, Usuario usuarioLogado) {
        initComponents();
        this.centralizarComponente();
        this.filmeSelecionado = filme;
        this.editar = editar;
        this.loadComboBox();
        this.loadTable();
        this.usuarioLogado = usuarioLogado;
        this.carregarCampos(filmeSelecionado);
        
        
    }
    
    public void loadTable(){
        jtComentarios.setModel(comentarioTableModel);
        jtComentarios.getColumnModel().getColumn(0).setMinWidth(0);
        jtComentarios.getColumnModel().getColumn(0).setMaxWidth(0);
        jtComentarios.getColumnModel().getColumn(0).setWidth(0);
    }
    
    public void loadValuesInTableComentarios(){
        
        this.comentarios = this.comentarioService.getAll();
        
        
    }
    
    
    private Comentario obterComentarioSelecionado(){
        
        int linhaSelecionada = jtComentarios.getSelectedRow();

        if (linhaSelecionada != -1) {
            int valorCelula = (int) jtComentarios.getValueAt(linhaSelecionada, 0);
            
            if (valorCelula > 0) {
                return comentarioService.getbyId(valorCelula);
            }

        }
        return null;
    }


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDiretor = new javax.swing.JTextField();
        lblPais = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        lblAno = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        cbGenero = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTituloFilme = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblDiretor = new javax.swing.JLabel();
        btnAdicionarGenero = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtComentarios = new javax.swing.JTable();
        btnComentario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        txtDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiretorActionPerformed(evt);
            }
        });

        lblPais.setText("Pais");

        lblAno.setText("Ano");

        cbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGeneroActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        lblTituloFilme.setText("Título:");

        lblGenero.setText("Genero:");

        lblDiretor.setText("Diretor:");

        btnAdicionarGenero.setText("+");
        btnAdicionarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarGeneroActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Cadastre um novo Filme:");
        lblHeader.setToolTipText("");

        jtComentarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtComentarios);

        btnComentario.setText("+");
        btnComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPais, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPais)
                                    .addComponent(txtAno)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTituloFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                        .addComponent(lblDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDiretor)
                                    .addComponent(txtTitulo)
                                    .addComponent(cbGenero, 0, 183, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionarGenero)
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnComentario)
                        .addContainerGap(21, Short.MAX_VALUE))))
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTituloFilme)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenero)
                            .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionarGenero))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiretor)
                            .addComponent(txtDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPais)
                            .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComentario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiretorActionPerformed
        
        
    }//GEN-LAST:event_txtDiretorActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
        if(editar == false){
            
            //CODIGO PARA SALVAR
            Filme filme = new Filme();
            filme.setAno(this.txtAno.getText());
            filme.setDiretor(this.txtDiretor.getText()); 
            filme.setGenero(this.cbGenero.getItemAt(cbGenero.getSelectedIndex())); 
            filme.setPais(this.txtPais.getText()); 
            filme.setTitulo(this.txtTitulo.getText()); 

        
        try{
            filmeService.save(filme);
            JOptionPane.showMessageDialog(this, "Filme salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Não foi possível salvar o filme", "Erro de persistencia", JOptionPane.ERROR_MESSAGE);
        }
        
        
        }else{
            
            //CODIGO PARA EDITAR
            Filme filmeEditado = new Filme();
            filmeEditado.setAno(this.txtAno.getText());
            filmeEditado.setDiretor(this.txtDiretor.getText()); 
            filmeEditado.setGenero(this.cbGenero.getItemAt(cbGenero.getSelectedIndex())); 
            filmeEditado.setPais(this.txtPais.getText()); 
            filmeEditado.setTitulo(this.txtTitulo.getText());
            
            filmeEditado.setId(filmeSelecionado.getId());
            
            try{
                filmeService.update(filmeEditado);
                JOptionPane.showMessageDialog(this, "Filme atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Não foi possível atualizar o filme", "Erro de persistencia", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAdicionarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarGeneroActionPerformed
        // TODO add your handling code here:
        GeneroDialog generodialog = new GeneroDialog(this, true);
        generodialog.setVisible(true);
    }//GEN-LAST:event_btnAdicionarGeneroActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
        //instanciar a lista de genero no combo box
        
        
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentarioActionPerformed
        // TODO add your handling code here:
        ComentarioDialog comentarioDialog = new ComentarioDialog(this, true, filmeSelecionado, this.usuarioLogado );
        comentarioDialog.setVisible(true);
        
        
    }//GEN-LAST:event_btnComentarioActionPerformed

    private void cbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGeneroActionPerformed

    
    public void loadComboBox(){
        comboGenero = generoService.getAll();
        cbGenero.setModel(new DefaultComboBoxModel(comboGenero.toArray()));
    }
    
    public void centralizarComponente() { 
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = getSize(); setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
    }
    
    public void carregarCampos(Filme filme){
        this.txtAno.setText(filme.getAno());
        this.txtDiretor.setText(filme.getDiretor());
        this.txtPais.setText(filme.getPais());
        this.txtTitulo.setText(filme.getTitulo());
        String generoString = filme.getGenero().getDescricao();

        // Iterate through the comboGenero list to find the index of generoString
        int generoIndex = 0;
        for (Genero genero : comboGenero) {
            if (genero.getDescricao().equals(generoString)) {
                break;
            }
            generoIndex++;
        }

        // Set the selected item in the combo box based on the index
        this.cbGenero.setSelectedIndex(generoIndex);
        
        
        //settar campos
        this.lblHeader.setText("Editar um filme e visualizar informações");
        this.btnSalvar.setText("Atualizar");
        
        
        
    }
    
    public void validarTela(){
        if(editar == true){
            this.lblHeader.setText("Editar um filme");
        }else{
            this.lblHeader.setText("Cadastrar um novo filme");
        }
        
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarGenero;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComentario;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Genero> cbGenero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtComentarios;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblDiretor;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblTituloFilme;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtDiretor;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
