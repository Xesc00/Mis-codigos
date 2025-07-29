using DocumentFormat.OpenXml.Spreadsheet;
using SpreadsheetLight;
using System.Data;
using System.Globalization;
using System.Text.Json;
using System.Windows.Forms;

namespace Transfomrar_Excel_a_Json
{
    public partial class Form1 : Form
    {
        DataTable dt;
        public String pathFile;
        List<Cliente> listaTotal = new List<Cliente>();
        List<Cliente> listClientesOrdenada = new List<Cliente>();

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //Leer();
        }

        private void btFinder_Click(object sender, EventArgs e)
        {
            if (openFD.ShowDialog() == DialogResult.OK)
            {
                pathFile = openFD.FileName;
                tBRuta.Text = pathFile;
                pathFile = tBRuta.Text;
            }
        }
        public void Leer()
        {
            dt = new DataTable();
            dt.Clear();

            int x = 1;
            int y = 1;

            List<Cliente> list = new List<Cliente>();
            SLDocument xsls = new SLDocument(pathFile);

            //Si la columna esta vacia se detendra el bucle
            while (!string.IsNullOrEmpty(xsls.GetCellValueAsString(x, 1)))
            {
                //El primer bucle es para dar nombres a las columnas
                if (x == 1)
                {
                    while (!string.IsNullOrEmpty(xsls.GetCellValueAsString(1, y)))
                    {
                        dt.Columns.Add(xsls.GetCellValueAsString(x, y++));
                        if(y==9)break;
                    }
                }
                else
                {
                    list.Add(AddCliente(xsls, x));
                }

                y = 1;
                x++;
            }

            DataRow dr = dt.NewRow();
            listaTotal = list;

            AñadirFilas(list);
        }

        private void btDale_Click(object sender, EventArgs e)
        {
            Leer();
            //dataGridView1.DataSource = dt;
        }
        public void Ordenar()
        {
            Dictionary<string, int> ordenDias = new()
            {
                { "L", 1 },
                { "M", 2 },
                { "X", 3 },
                { "J", 4 },
                { "V", 5 }
            };

            var ordenado = listaTotal.OrderBy(c =>
            {
                var primerDia = c.DiasPedido.FirstOrDefault();
                return ordenDias.ContainsKey(primerDia) ? ordenDias[primerDia] : 99;
            }).ToList();

            AñadirFilas(ordenado);
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

            listClientesOrdenada = OrdenarSemana();

            AñadirFilas(listClientesOrdenada);

        }

        private void buttonOrder_Click(object sender, EventArgs e)
        {
            Ordenar();

            dataGridView1.DataSource = dt;
        }

        //Metodo para ordenar la lista de clientes que se muestra por dias de la semana
        public List<Cliente> OrdenarSemana()
        {

            //Aqui guardo el valor del comobBox en un String para poder comporbar que dia se ha elegido
            String dia = comboBOrder.Items[comboBOrder.SelectedIndex].ToString();

            List<Cliente> listClientes = new List<Cliente>();

            switch (dia)
            {
                case "Lunes":
                    listClientes = listaTotal.Where(c =>
                        c.DiasPedido != null && c.DiasPedido.Contains("L")
                    ).ToList();
                    break;
                case "Martes":
                    listClientes = listaTotal.Where(c =>
                        c.DiasPedido != null && c.DiasPedido.Contains("M")
                    ).ToList();
                    break;
                case "Miercoles":
                    listClientes = listaTotal.Where(c =>
                        c.DiasPedido != null && c.DiasPedido.Contains("X")
                    ).ToList();
                    break;
                case "Jueves":
                    listClientes = listaTotal.Where(c =>
                        c.DiasPedido != null && c.DiasPedido.Contains("J")
                    ).ToList();
                    break;
                case "Viernes":
                    listClientes = listaTotal.Where(c =>
                        c.DiasPedido != null && c.DiasPedido.Contains("V")
                    ).ToList();
                    break;

            }
            return listClientes;
        }
        //Metodo para crear el objeto cliente atraves de los datos que se extraen del documento 
        public Cliente AddCliente(SLDocument xsls, int x)
        {
            Cliente client = new Cliente();


            client.Id = xsls.GetCellValueAsString(x, 1);
            client.Name = xsls.GetCellValueAsString(x, 2);

            client.FechaAdquisicion = xsls.GetCellValueAsString(x, 3);

            client.Descripcion = xsls.GetCellValueAsString(x, 4);

            string diasPedido = xsls.GetCellValueAsString(x, 5);
            client.DiasPedido = diasPedido
                .Split(',', StringSplitOptions.RemoveEmptyEntries)
                .Select(d => d.Trim())
                .ToList();

            string diasReparto = xsls.GetCellValueAsString(x, 6);
            client.DiasReparto = diasReparto
                .Split(',', StringSplitOptions.RemoveEmptyEntries)
                .Select(d => d.Trim())
                .ToList();

            string ultimoPedido = xsls.GetCellValueAsString(x, 7);
            List<String> l = ultimoPedido
                .Split(',', StringSplitOptions.RemoveEmptyEntries)
                .Select(d => d.Trim())
                .ToList();
            
            List<Pedido> ultimoP = new List<Pedido>();
            Pedido ped;

            foreach (String s in l) { 
                List<String> Produ = s.Split(':').ToList();

                string nomProdu = Produ[0];
                int cantidad = Int32.Parse(Produ[1]);

                ped = new Pedido(nomProdu, cantidad);
                ultimoP.Add(ped);
            }

            client.UltimoPedido = ultimoP;
             
            client.DiaUltimoPedido = xsls.GetCellValueAsString(x, 8);
            client.HoraLlamada = xsls.GetCellValueAsString(x, 9);
            client.HoraReparto = xsls.GetCellValueAsString(x, 10);

            return client;
        }
        public void AñadirFilas(List<Cliente> listClientes)
        {
            dataGridView1.DataSource = null;
            dt.Rows.Clear();
            foreach (var cliente in listClientes)
            {
                DataRow row = dt.NewRow();
                row[0] = cliente.Id;
                row[1] = cliente.Name;
                row[2] = cliente.FechaAdquisicion;
                row[3] = cliente.Descripcion;
                row[4] = string.Join(", ", cliente.DiasPedido);
                row[5] = string.Join(", ", cliente.DiasReparto);
                row[6] = string.Join("\n", cliente.UltimoPedido);
                row[7] = cliente.DiaUltimoPedido;

                dt.Rows.Add(row);
            }
            dataGridView1.DataSource = dt;
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            Cliente cliente = new Cliente();
            String id = dataGridView1.CurrentRow.Cells[0].Value.ToString();
            cliente = listaTotal.Find(x => x.Id == id);
            
            Form dataCliente = new InfoCliente(cliente);
            dataCliente.ShowDialog();
        }
    }
}
