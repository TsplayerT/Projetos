package testes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OrdenarAlfabeticamente extends JFrame implements ActionListener {

    String data = null;
    String itens = "";
    String[] nomes;

    JButton jbo = new JButton("Organizar");
    JButton jbp = new JButton("Procurar");
    JLabel jle = new JLabel("Esse programa organiza alfabeticamente as linhas de um arquivo de texto.");
    JLabel jld = new JLabel("Coloque o diretório do arquivo:");
    JTextField jtf = new JTextField();
    JFileChooser jfc = new JFileChooser();

    public OrdenarAlfabeticamente() {
        setVisible(true);
        setSize(500, 215);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Ordenar Linhas Alfabeticamente");
        setLayout(null);
        jle.setBounds(30, 20, 450, 20);
        add(jle);
        jld.setBounds(30, 80, 200, 20);
        add(jld);
        jbp.setBounds(30, 105, 100, 25);
        add(jbp);
        jtf.setBounds(135, 105, 315, 25);
        add(jtf);
        jbo.setBounds(200, 145, 100, 30);
        add(jbo);
        jbp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ProcurarArquivo();
            }
        });
        jbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    Ler();
                    bubbleSort();
                    Escrever();
                    JOptionPane.showMessageDialog(null, "Arquivo organizado com sucesso!");
                } catch (IOException erro) {
                    JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
                }
            }
        });
    }

    public void ProcurarArquivo() {
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = jfc.showSaveDialog(null);
        if (i == 1) {
            jtf.setText("");
        } else {
            File arquivo = jfc.getSelectedFile();
            jtf.setText(arquivo.getPath());
        }
    }

    public void Ler() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(jtf.getText());
        BufferedReader reader = new BufferedReader(fileReader);
        while ((data = reader.readLine()) != null) {
            if (!"".equals(itens)) {
                itens += ",";
            }
            itens += data;
        }
        nomes = itens.split(",");
    }

    public void bubbleSort() {
        int tamanho = nomes.length;
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (nomes[j].compareTo(nomes[ j + 1]) > 0) {
                    String auxiliar = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = auxiliar;
                }
            }
        }
    }

    public void Escrever() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(jtf.getText(), false));
        for (int i = 0; i < nomes.length; i++) {
            writer.write(nomes[i]);
            writer.newLine();
        }
        writer.flush();
        writer.close();
        nomes = null;
    }

    public static void main(String[] args) throws IOException {
        new OrdenarAlfabeticamente();
    }

    public void actionPerformed(ActionEvent e) {
    }
}
