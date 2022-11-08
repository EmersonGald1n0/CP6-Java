package fiap.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import fiap.controller.FilmesController;

@SuppressWarnings("serial")
public class GUIFilmes extends JPanel {
	private JLabel lbCodigo, lbTitulo, lbProdutora, lbGenero, lbImagem;
	private JTextField tfCodigo, tfTitulo;
	private JRadioButton rbWarner, rbFox, rbDisney, rbUniversal;
	private JList<String> liGeneros;
	private ImageIcon imagem1;
	private JScrollPane sp;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;

	public GUIFilmes() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.lightGray);

		lbCodigo = new JLabel("Codigo:");
		lbTitulo = new JLabel("Titulo:");
		tfCodigo = new JTextField();
		tfTitulo = new JTextField();

		btPesquisa = new JButton(new ImageIcon(getClass().getResource("CP6_imagens/search_icon.png")));
		btNovo = new JButton(new ImageIcon(getClass().getResource("CP6_imagens/new_icon.png")));
		btAtualiza = new JButton(new ImageIcon(getClass().getResource("CP6_imagens/update_icon.png")));
		btApaga = new JButton(new ImageIcon(getClass().getResource("CP6_imagens/delete_icon.png")));

		lbProdutora = new JLabel("Produtora:");
		rbWarner = new JRadioButton("Warner", true);
		rbWarner.setBackground(getBackground());
		rbFox = new JRadioButton("Fox");
		rbFox.setBackground(getBackground());
		rbDisney = new JRadioButton("Disney");
		rbDisney.setBackground(getBackground());
		rbUniversal = new JRadioButton("Universal");
		rbUniversal.setBackground(getBackground());

		String[] generos = new String[5];
		generos[0] = "Fantasia";
		generos[1] = "Infantil";
		generos[2] = "Medieval";
		generos[3] = "Nórdico";
		generos[4] = "Terror";

		liGeneros = new JList<String>(generos);
		sp = new JScrollPane(liGeneros);
		lbGenero = new JLabel("Genero:");
		imagem1 = new ImageIcon();
		lbImagem = new JLabel(imagem1);

		lbCodigo.setBounds(10, 30, 60, 25);
		tfCodigo.setBounds(80, 30, 50, 25);
		lbTitulo.setBounds(10, 60, 60, 25);
		tfTitulo.setBounds(80, 60, 160, 25);

		lbProdutora.setBounds(10, 100, 70, 25);
		rbWarner.setBounds(20, 125, 100, 25);
		rbFox.setBounds(20, 150, 100, 25);
		rbDisney.setBounds(20, 175, 100, 25);
		rbUniversal.setBounds(20, 200, 100, 25);

		lbGenero.setBounds(260, 30, 60, 25);
		sp.setBounds(260, 60, 100, 95);
		lbImagem.setBounds(400, 0, 180, 180);

		btPesquisa.setBounds(100, 250, 60, 40);
		btNovo.setBounds(210, 250, 60, 40);
		btAtualiza.setBounds(320, 250, 60, 40);
		btApaga.setBounds(430, 250, 60, 40);

		add(lbCodigo);
		add(tfCodigo);

		add(lbTitulo);
		add(tfTitulo);

		add(lbProdutora);
		add(rbWarner);
		add(rbFox);
		add(rbDisney);
		add(rbUniversal);

		add(lbGenero);
		add(sp);
		add(lbImagem);

		add(btPesquisa);
		add(btNovo);
		add(btAtualiza);
		add(btApaga);

	}

	private void definirEventos() {
		liGeneros.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				imagem1 = new ImageIcon(getClass().getResource("CP6_imagens/" + liGeneros.getSelectedValue() + ".png"));
				lbImagem.setIcon(imagem1);
			}
		});

		btApaga.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FilmesController filmes = new FilmesController();

				if (tfCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o código");
					tfCodigo.requestFocus();

				} else {
					JOptionPane.showMessageDialog(null, filmes.excluiFilmes(tfCodigo.getText()));

					tfCodigo.setText("");
					tfTitulo.setText("");
				}
			}
		});

		btAtualiza.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FilmesController filmes = new FilmesController();

				if (tfCodigo.getText().equals("") || tfTitulo.getText().equals("") || lbGenero.getText().equals("") // talvez
																													// apague
						|| lbProdutora.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
					tfCodigo.requestFocus();

				} else {
					JOptionPane.showMessageDialog(null, filmes.alteraFilmes(tfCodigo.getText(), tfTitulo.getText(),
							lbGenero.getText(), lbProdutora.getText()));
					tfCodigo.setText("");
					tfTitulo.setText("");
					lbGenero.setText("");
					lbProdutora.setText(""); // TALVEZ SEJA REMOVIDO TODOS LB
				}
			}
		});

		btNovo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FilmesController filmes = new FilmesController();
				String produtora = "";
				if (rbWarner.isSelected()) {
					produtora = "Warner";
				} else if (rbFox.isSelected()) {
					produtora = "Fox";
				} else if (rbDisney.isSelected()) {
					produtora = "Disney";
				} else if (rbUniversal.isSelected()) {
					produtora = "Universal";
				} else {
					produtora = "";
				}
				if (tfCodigo.getText().equals("") || tfTitulo.getText().equals("") || produtora.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
					tfCodigo.requestFocus();

				} else {
					JOptionPane.showMessageDialog(null, filmes.insereFilmes(tfCodigo.getText(), tfTitulo.getText(),
							liGeneros.getSelectedValue(), produtora));
					tfCodigo.setText("");
					tfTitulo.setText("");
				}
			}
		});

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmesController filmes = new FilmesController();
				ArrayList<String> dados = new ArrayList<String>();

				if (tfCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o código");
					tfCodigo.requestFocus();

				} else {
					dados = filmes.listaFilmes(tfCodigo.getText());
					if (dados != null) {
						tfTitulo.setText(dados.get(1));
						lbGenero.setText(dados.get(2));
						lbProdutora.setText(dados.get(3));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
				}
			}
		});

	}
}