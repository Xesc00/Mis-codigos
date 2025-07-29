using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Transfomrar_Excel_a_Json
{
    public partial class InfoCliente : Form
    {
        Cliente cliente;
        public InfoCliente(Cliente cliente)
        {
            InitializeComponent();
            this.cliente = cliente;
            lb_Nombre.Text = cliente.Name;
            lb_FechaUltimoPedido.Text = cliente.DiaUltimoPedido;
            lb_CodigoCliente.Text = cliente.Id.ToString();

            foreach (var r in cliente.UltimoPedido)
            {
                listB_ListaUltimoPedido.Items.Add(r);
                listB_ListaUltimoPedido.ClearSelected();
            }

            lb_DiasReparto.Text = "";

            foreach (var dias in cliente.DiasReparto)
            {
                switch (dias)
                {
                    case "L":
                        lb_DiasReparto.Text += "Lunes ";
                        break;
                    case "M":
                        lb_DiasReparto.Text += "Martes ";
                        break;
                    case "X":
                        lb_DiasReparto.Text += "Miercoles ";
                        break;
                    case "J":
                        lb_DiasReparto.Text += "Jueves ";
                        break;
                    case "V":
                        lb_DiasReparto.Text += "Viernes";
                        break;
                }
            }

            lb_HoraLlamada.Text = cliente.HoraLlamada;
            lb_HoraReparto.Text = cliente.HoraReparto;
            

        }

        private void InfoCliente_Load(object sender, EventArgs e)
        {

        }
    }
}
