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

public class FilmeTableModel extends AbstractTableModel  {
    private LinkedList<Filme> dados = new LinkedList<>();
    private String[] colunas = {"Id", "Titulo", "Genero", "Ano"};
  
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
                return this.dados.get(linha).getTitulo();
            case 2:
                return this.dados.get(linha).getGenero().getDescricao();
            case 3:
                return this.dados.get(linha).getAno();
            
        }

        return null;
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

    public void addRow(Filme filme) {
        this.dados.add(filme);
        this.fireTableDataChanged();
    }

    public void addRows(LinkedList<Filme> filmes) {
        this.dados.addAll(filmes);
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
