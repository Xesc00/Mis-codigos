namespace Transfomrar_Excel_a_Json
{
    partial class InfoCliente
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            lb_Nombre = new Label();
            lb_Tel = new Label();
            label1 = new Label();
            listB_ListaUltimoPedido = new ListBox();
            lb_FechaUltimoPedido = new Label();
            label2 = new Label();
            label3 = new Label();
            lb_DiasReparto = new Label();
            lb_HoraLlamada = new Label();
            label4 = new Label();
            lb_HoraReparto = new Label();
            lb_CodigoCliente = new Label();
            label5 = new Label();
            SuspendLayout();
            // 
            // lb_Nombre
            // 
            lb_Nombre.AutoSize = true;
            lb_Nombre.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lb_Nombre.Location = new Point(12, 9);
            lb_Nombre.Name = "lb_Nombre";
            lb_Nombre.Size = new Size(70, 19);
            lb_Nombre.TabIndex = 0;
            lb_Nombre.Text = "Nombre";
            // 
            // lb_Tel
            // 
            lb_Tel.AutoSize = true;
            lb_Tel.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lb_Tel.Location = new Point(12, 69);
            lb_Tel.Name = "lb_Tel";
            lb_Tel.Size = new Size(75, 19);
            lb_Tel.TabIndex = 1;
            lb_Tel.Text = "Telefono";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.Location = new Point(12, 99);
            label1.Name = "label1";
            label1.Size = new Size(116, 19);
            label1.TabIndex = 2;
            label1.Text = "Ultimo Pedido";
            // 
            // listB_ListaUltimoPedido
            // 
            listB_ListaUltimoPedido.BackColor = SystemColors.GradientInactiveCaption;
            listB_ListaUltimoPedido.BorderStyle = BorderStyle.None;
            listB_ListaUltimoPedido.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            listB_ListaUltimoPedido.FormattingEnabled = true;
            listB_ListaUltimoPedido.ImeMode = ImeMode.Off;
            listB_ListaUltimoPedido.ItemHeight = 17;
            listB_ListaUltimoPedido.Location = new Point(12, 130);
            listB_ListaUltimoPedido.Name = "listB_ListaUltimoPedido";
            listB_ListaUltimoPedido.Size = new Size(312, 102);
            listB_ListaUltimoPedido.TabIndex = 3;
            // 
            // lb_FechaUltimoPedido
            // 
            lb_FechaUltimoPedido.AutoSize = true;
            lb_FechaUltimoPedido.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lb_FechaUltimoPedido.Location = new Point(157, 99);
            lb_FechaUltimoPedido.Name = "lb_FechaUltimoPedido";
            lb_FechaUltimoPedido.Size = new Size(159, 19);
            lb_FechaUltimoPedido.TabIndex = 4;
            lb_FechaUltimoPedido.Text = "fecha ultimo pedido";
            lb_FechaUltimoPedido.TextAlign = ContentAlignment.MiddleRight;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label2.Location = new Point(12, 255);
            label2.Name = "label2";
            label2.Size = new Size(108, 19);
            label2.TabIndex = 5;
            label2.Text = "Dias Reparto";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label3.Location = new Point(12, 353);
            label3.Name = "label3";
            label3.Size = new Size(169, 19);
            label3.TabIndex = 6;
            label3.Text = "Hora realizar pedido:";
            // 
            // lb_DiasReparto
            // 
            lb_DiasReparto.AutoSize = true;
            lb_DiasReparto.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lb_DiasReparto.Location = new Point(30, 274);
            lb_DiasReparto.Name = "lb_DiasReparto";
            lb_DiasReparto.Size = new Size(19, 19);
            lb_DiasReparto.TabIndex = 7;
            lb_DiasReparto.Text = "d";
            lb_DiasReparto.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // lb_HoraLlamada
            // 
            lb_HoraLlamada.AutoSize = true;
            lb_HoraLlamada.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lb_HoraLlamada.Location = new Point(201, 353);
            lb_HoraLlamada.Name = "lb_HoraLlamada";
            lb_HoraLlamada.Size = new Size(107, 19);
            lb_HoraLlamada.TabIndex = 8;
            lb_HoraLlamada.Text = "hora llamada";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label4.Location = new Point(12, 391);
            label4.Name = "label4";
            label4.Size = new Size(182, 19);
            label4.TabIndex = 9;
            label4.Text = "Repartir a partir de las:";
            // 
            // lb_HoraReparto
            // 
            lb_HoraReparto.AutoSize = true;
            lb_HoraReparto.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lb_HoraReparto.Location = new Point(201, 391);
            lb_HoraReparto.Name = "lb_HoraReparto";
            lb_HoraReparto.Size = new Size(103, 19);
            lb_HoraReparto.TabIndex = 10;
            lb_HoraReparto.Text = "hora reparto";
            // 
            // lb_CodigoCliente
            // 
            lb_CodigoCliente.AutoSize = true;
            lb_CodigoCliente.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lb_CodigoCliente.Location = new Point(134, 39);
            lb_CodigoCliente.Name = "lb_CodigoCliente";
            lb_CodigoCliente.Size = new Size(119, 19);
            lb_CodigoCliente.TabIndex = 11;
            lb_CodigoCliente.Text = "Codigo cliente";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Arial", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label5.Location = new Point(12, 39);
            label5.Name = "label5";
            label5.Size = new Size(119, 19);
            label5.TabIndex = 12;
            label5.Text = "Codigo cliente";
            // 
            // InfoCliente
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.GradientActiveCaption;
            ClientSize = new Size(336, 445);
            Controls.Add(label5);
            Controls.Add(lb_CodigoCliente);
            Controls.Add(lb_HoraReparto);
            Controls.Add(label4);
            Controls.Add(lb_HoraLlamada);
            Controls.Add(lb_DiasReparto);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(lb_FechaUltimoPedido);
            Controls.Add(listB_ListaUltimoPedido);
            Controls.Add(label1);
            Controls.Add(lb_Tel);
            Controls.Add(lb_Nombre);
            MaximizeBox = false;
            Name = "InfoCliente";
            Text = "InfoCliente";
            Load += InfoCliente_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lb_Nombre;
        private Label lb_Tel;
        private Label label1;
        private ListBox listB_ListaUltimoPedido;
        private Label lb_FechaUltimoPedido;
        private Label label2;
        private Label label3;
        private Label lb_DiasReparto;
        private Label lb_HoraLlamada;
        private Label label4;
        private Label lb_HoraReparto;
        private Label lb_CodigoCliente;
        private Label label5;
    }
}