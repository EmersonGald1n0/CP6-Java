package fiap.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame {

	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnCadastro;
	private JMenuItem miSair, miFilmes;

	public GUIPrincipal() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setTitle("Checkpoint 06");
		setBounds(0, 0, 600, 400);
		contentPane = getContentPane();

		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnCadastro = new JMenu("Cadastro");
		mnArquivo.setMnemonic('C');
		miSair = new JMenuItem("Sair", new ImageIcon(getClass().getResource("CP6_imagens/exit_icon.png")));
		miFilmes = new JMenuItem("Filmes");

		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnCadastro);
		mnArquivo.add(miSair);
		mnCadastro.add(miFilmes);
	}

	private void definirEventos() {
		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		miFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIFilmes filmes = new GUIFilmes();
				contentPane.removeAll();
				contentPane.add(filmes);
				contentPane.validate();
			}
		});

	}

	public static void main(String[] args) {
		GUIPrincipal frame = new GUIPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}

}
