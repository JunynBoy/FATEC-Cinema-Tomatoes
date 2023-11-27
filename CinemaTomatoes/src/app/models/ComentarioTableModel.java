package app.models;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ComentarioTableModel extends AbstractTableModel  {
    private LinkedList<Comentario> dados = new LinkedList<>();
    private String[] colunas = {"id","Comentarios","Notas" , "Usuarios"};
  
    @Override
    public String getColumnName(int coluna) {
        return this.colunas[coluna];
    }

    @Override
    public int getRowCount() {
        return this.dados.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return this.dados.get(linha).getId();
            case 1:
                return this.dados.get(linha).getComentario();
            case 2:
                return this.dados.get(linha).getNota();
            case 3:
                return this.dados.get(linha).getUsuario();
            
        }

        return null;
    }
    
    
    private class BotoesAcao extends JButton {
        public BotoesAcao() {
            this.add(new JButton("Editar"));
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        // Permitir a edição apenas para a coluna de ação (botões)
        return col == 4;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 4) {
            // Tratar ação do botão
            JOptionPane.showMessageDialog(null, "Botão clicado para a linha: " + row);
        }
    }

    public void addRow(Comentario comentario) {
        this.dados.add(comentario);
        this.fireTableDataChanged();
    }

    public void addRows(LinkedList<Comentario> comentario) {
        this.dados.addAll(comentario);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public void removeAllRows() {
        this.dados = new LinkedList<>();
        this.fireTableRowsDeleted(0, this.getRowCount());
    }
}
