import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UI extends JFrame {
    public UI(){
        //jframe
        super("User Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);

        //Menu da seção Arquivo
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu arqMenu = new JMenu("Arquivo");
        JMenu envSubMenu = new JMenu("Enviar");
        JMenu editMenu = new JMenu("Editar");
        envSubMenu.add(new JMenuItem("Email"));
        envSubMenu.add(new JMenuItem("Impressora"));
        arqMenu.add(envSubMenu);
        arqMenu.add(new JMenuItem("Salvar"));
        arqMenu.add(new JMenuItem("Sair"));
        menuBar.add(arqMenu);
        menuBar.add(editMenu);

        // Painel principal
        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
        formContainer.setBorder(new EmptyBorder(5, 5, 5, 5));

        // componentes
        JLabel lblTitulo = new JLabel("Avaliação");
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 16));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        formContainer.add(lblTitulo);
        formContainer.add(Box.createVerticalStrut(15));
        //Campo codigo
        formContainer.add(createLabelAndFieldPanel("Código:", new JTextField()));
        //Campo nome
        formContainer.add(createLabelAndFieldPanel("Nome:", new JTextField()));
        //Campo sexo com check box
        JPanel sexoPanel = new JPanel(new BorderLayout(5, 5));
        sexoPanel.add(new JLabel("Sexo:"), BorderLayout.WEST);
        JRadioButton rbFeminino = new JRadioButton("Feminino");
        JRadioButton rbMasculino = new JRadioButton("Masculino");
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(rbFeminino);
        sexoGroup.add(rbMasculino);
        JPanel checkBox = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        checkBox.add(rbFeminino); 
        checkBox.add(rbMasculino);
        sexoPanel.add(checkBox, BorderLayout.CENTER);
        sexoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, sexoPanel.getPreferredSize().height)); 
        formContainer.add(sexoPanel);
        formContainer.add(Box.createVerticalStrut(10));
        
        //Campo curriculum
        JPanel curriculumPanel = new JPanel(new BorderLayout());
        curriculumPanel.add(new JLabel("Curriculum Vitae"), BorderLayout.NORTH);
        JTextArea txtCurriculum = new JTextArea(10, 20);
        curriculumPanel.add(new JScrollPane(txtCurriculum), BorderLayout.CENTER);
        formContainer.add(curriculumPanel);
        formContainer.add(Box.createVerticalStrut(10));
        
        //Seção
        JPanel areasSectionPanel = new JPanel(new BorderLayout());
        areasSectionPanel.add(new JLabel("Áreas"), BorderLayout.NORTH);
        JPanel areasFieldsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        areasFieldsPanel.add(new JLabel("Interesse:"));
        areasFieldsPanel.add(new JComboBox<>(new String[]{"Desenvolvedor"}));
        areasFieldsPanel.add(new JLabel("Atuação:"));
        areasFieldsPanel.add(new JComboBox<>(new String[]{"Programação"}));
        areasSectionPanel.add(areasFieldsPanel, BorderLayout.CENTER);
        areasSectionPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, areasSectionPanel.getPreferredSize().height));
        formContainer.add(areasSectionPanel);
        //Botões embaixo
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(new JButton("Salvar"));
        buttonPanel.add(new JButton("Anterior"));
        buttonPanel.add(new JButton("Proximo"));
        buttonPanel.add(new JButton("Novo"));
        buttonPanel.add(new JButton("Cancelar"));
        getContentPane().add(formContainer, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    private JPanel createLabelAndFieldPanel(String labelText, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(new JLabel(labelText), BorderLayout.WEST);
        panel.add(component, BorderLayout.CENTER);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));
        
        return panel;
    }
}
