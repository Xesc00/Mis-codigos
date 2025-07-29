using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Transfomrar_Excel_a_Json
{
    public class Cliente
    {
        public String Id { get; set; }
        public String Name { get; set; }
        public String? FechaAdquisicion { get; set; }
        public String? Descripcion { get; set; }
        public List<String>? DiasPedido { get; set; }
        public List<String>? DiasReparto { get; set; }
        public List<Pedido>? UltimoPedido { get; set; }
        public String DiaUltimoPedido { get; set; }
        public String HoraLlamada { get; set; }
        public String HoraReparto { get; set; }
        public Cliente(String id, String Name, String FechaAdquisicion,
            String Descripcion, List<String> DiasPedido, List<String> DiasReparto, 
            List<Pedido> UltimoPedido, String DiaUltimoPedido, String HoraLlamada, 
            String HoraReparto) 
        {
            this.Id = id;
            this.Name = Name;
            this.FechaAdquisicion = FechaAdquisicion;
            this.Descripcion = Descripcion;
            this.DiasPedido = DiasPedido;
            this.DiasReparto = DiasReparto;
            this.UltimoPedido = UltimoPedido;
            this.DiaUltimoPedido = DiaUltimoPedido;
            this.HoraLlamada = HoraLlamada;
            this.HoraReparto = HoraReparto;
        }

        public Cliente()
        {

        }
        public Cliente GetCliente(Cliente client)
        {
            return client;
        }
    }
}
