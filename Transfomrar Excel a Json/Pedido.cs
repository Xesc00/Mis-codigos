using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Transfomrar_Excel_a_Json
{
    public class Pedido
    {
        public String? Producto { get; set; }
        public int? Cantidad {  get; set; }
        public Pedido(String Producto, int Cantidad)
        {
            this.Producto = Producto;
            this.Cantidad = Cantidad;
        }
        public Pedido() { }
        public override string ToString()
        {
            return $"{Producto}: {Cantidad}";
        }
        public Pedido GetPedido(Pedido Pedido)
        {
            return Pedido;
        }
    }
}
