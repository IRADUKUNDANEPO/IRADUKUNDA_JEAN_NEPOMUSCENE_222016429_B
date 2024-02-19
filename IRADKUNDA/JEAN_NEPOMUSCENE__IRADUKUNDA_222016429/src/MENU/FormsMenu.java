package MENU;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import AllForms.CustomersForm;
import AllForms.OrderForm;
import AllForms.ProductForm;
import AllForms.Stock_TransactionForm;
import AllForms.SupplierForm;


public class FormsMenu extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Productmenu;
    private JMenu Customersmenu;
    private JMenu Ordermenu;
    private JMenu Stock_Transactionmenu;
    private JMenu Suppliermenu;
    private JMenu Logoutmenu;
    


	public FormsMenu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem ProductItem;
    private JMenuItem CustomersItem;
    private JMenuItem OrderItem;
    private JMenuItem Stock_TransactionItem;
    private JMenuItem SupplierItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormsMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Productmenu = new JMenu("Product");
        Customersmenu = new JMenu("Customers");
        Ordermenu= new JMenu("Order");
        Stock_Transactionmenu = new JMenu("Stock_Transaction ");
        Suppliermenu = new JMenu("Supplier");
        Logoutmenu = new JMenu("SIGNING OUT");
        		

        // Create menu items
        menuBar.add(Productmenu);
        ProductItem = new JMenuItem("ProductForm");
        ProductItem.addActionListener(this);
        
        menuBar.add(Customersmenu);
        CustomersItem = new JMenuItem("CustomersForm");
        CustomersItem.addActionListener(this);
        
        menuBar.add(Ordermenu);
        OrderItem = new JMenuItem("OrderForm");
        OrderItem.addActionListener(this);
        
        menuBar.add(Stock_Transactionmenu);
        Stock_TransactionItem = new JMenuItem("Stock_TransactionForm");
        Stock_TransactionItem.addActionListener(this);
        
        menuBar.add(Suppliermenu);
        SupplierItem = new JMenuItem("SupplierForm");
        SupplierItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Productmenu.add(ProductItem);
        Customersmenu.add(CustomersItem);
        Ordermenu.add(OrderItem);
        Stock_Transactionmenu.add(Stock_TransactionItem);
        Suppliermenu.add(SupplierItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu barn
        // Set menu bar to frame
        setJMenuBar(menuBar);
        
        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\nepo\\Desktop\\Multimedia Pictures\\download.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

//"D:\\ALL PICTURES\\batma.jpg

        // Initialize dashboard panel
        JPanel dashboardPanel1 = new JPanel();
        dashboardPanel1.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel1.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel1);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ProductItem) {
            new ProductForm();
        
        } else if (e.getSource() == CustomersItem) {
            new CustomersForm();
        
        } else if (e.getSource() == OrderItem) {
            new OrderForm();
       
        } else if (e.getSource() == Stock_TransactionItem) {
           new Stock_TransactionForm();
        
        } else if (e.getSource() == SupplierItem) {
           new SupplierForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure! Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormsMenu("TO STOCK MANAGEMENT SYSTEM"));
    }
}




