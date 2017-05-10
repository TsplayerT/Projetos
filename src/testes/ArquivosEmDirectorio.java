package testes;

import java.io.File;
import java.util.Random;

public class ArquivosEmDirectorio {

    public void QuantidadeDeArquivosEmDirectorio(){
        File arquivo = new File("E:\\Outros\\Netbeans\\JogoRPG tudo");
        // Carrega todos os arquivos em um vetor
        File[] arquivos = arquivo.listFiles();
        int aux = 0;
        // Se há arquivos, entra nesta rotina
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File f = arquivos[i];
                if (f.isFile()) {
                    aux++;
                }
            }
            System.out.println("Quantidade de Arquivos: " + aux);
        }
    }
    
    public void NomesDosArquivosEmDirectorio(){
        File file = new File("E:\\Programas");
        File[] arquivos = file.listFiles();
        for (int i = 0; i < arquivos.length; i++) {
            System.out.println(arquivos[i].getName());
        }
    }
    
    public void RandomizarNomeDeConteudoEmDiretorio(){
        File file = new File("E:\\Jogos\\Minecraft");
        File[] arquivos = file.listFiles();
        Random r = new Random();
        int numero = r.nextInt(arquivos.length);
        System.out.println(arquivos[numero].getName());
    }
    public static void main(String[] args) {
        new ArquivosEmDirectorio().NomesDosArquivosEmDirectorio();
    }

}
