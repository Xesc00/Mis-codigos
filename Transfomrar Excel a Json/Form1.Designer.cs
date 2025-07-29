namespace Transfomrar_Excel_a_Json
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            GroupBox groupBox1;
            DataGridViewCellStyle dataGridViewCellStyle1 = new DataGridViewCellStyle();
            DataGridViewCellStyle dataGridViewCellStyle2 = new DataGridViewCellStyle();
            dataGridView1 = new DataGridView();
            openFD = new OpenFileDialog();
            btFinder = new Button();
            tBRuta = new TextBox();
            btDale = new Button();
            comboBOrder = new ComboBox();
            buttonOrder = new Button();
            groupBox1 = new GroupBox();
            groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)dataGridView1).BeginInit();
            SuspendLayout();
            // 
            // groupBox1
            // 
            groupBox1.Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right;
            groupBox1.BackgroundImageLayout = ImageLayout.None;
            groupBox1.Controls.Add(dataGridView1);
            groupBox1.Location = new Point(12, 109);
            groupBox1.Name = "groupBox1";
            groupBox1.Size = new Size(1111, 416);
            groupBox1.TabIndex = 9;
            groupBox1.TabStop = false;
            groupBox1.Text = " ";
            // 
            // dataGridView1
            // 
            dataGridView1.Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells;
            dataGridView1.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;
            dataGridView1.BackgroundColor = SystemColors.ActiveCaption;
            dataGridView1.BorderStyle = BorderStyle.None;
            dataGridView1.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewCellStyle1.Alignment = DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle1.BackColor = SystemColors.Window;
            dataGridViewCellStyle1.Font = new Font("Segoe UI", 9F);
            dataGridViewCellStyle1.ForeColor = SystemColors.ControlText;
            dataGridViewCellStyle1.SelectionBackColor = SystemColors.Highlight;
            dataGridViewCellStyle1.SelectionForeColor = SystemColors.HighlightText;
            dataGridViewCellStyle1.WrapMode = DataGridViewTriState.True;
            dataGridView1.DefaultCellStyle = dataGridViewCellStyle1;
            dataGridView1.GridColor = SystemColors.InactiveCaption;
            dataGridView1.Location = new Point(25, 22);
            dataGridView1.Name = "dataGridView1";
            dataGridViewCellStyle2.Alignment = DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle2.BackColor = SystemColors.Control;
            dataGridViewCellStyle2.Font = new Font("Segoe UI", 9F);
            dataGridViewCellStyle2.ForeColor = SystemColors.WindowText;
            dataGridViewCellStyle2.SelectionBackColor = SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = SystemColors.HighlightText;
            dataGridView1.RowHeadersDefaultCellStyle = dataGridViewCellStyle2;
            dataGridView1.RowTemplate.Height = 24;
            dataGridView1.Size = new Size(1069, 386);
            dataGridView1.TabIndex = 6;
            dataGridView1.CellContentClick += dataGridView1_CellContentClick;
            // 
            // openFD
            // 
            openFD.FileName = "openFD";
            // 
            // btFinder
            // 
            btFinder.Location = new Point(382, 26);
            btFinder.Name = "btFinder";
            btFinder.Size = new Size(25, 23);
            btFinder.TabIndex = 0;
            btFinder.Text = "...";
            btFinder.UseVisualStyleBackColor = true;
            btFinder.Click += btFinder_Click;
            // 
            // tBRuta
            // 
            tBRuta.Location = new Point(24, 26);
            tBRuta.Name = "tBRuta";
            tBRuta.Size = new Size(352, 23);
            tBRuta.TabIndex = 1;
            tBRuta.Text = "Selecciona un fichero";
            // 
            // btDale
            // 
            btDale.Location = new Point(186, 54);
            btDale.Name = "btDale";
            btDale.Size = new Size(75, 23);
            btDale.TabIndex = 5;
            btDale.Text = "Dale";
            btDale.UseVisualStyleBackColor = true;
            btDale.Click += btDale_Click;
            // 
            // comboBOrder
            // 
            comboBOrder.FormattingEnabled = true;
            comboBOrder.Items.AddRange(new object[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes" });
            comboBOrder.Location = new Point(428, 27);
            comboBOrder.Name = "comboBOrder";
            comboBOrder.Size = new Size(121, 23);
            comboBOrder.TabIndex = 7;
            comboBOrder.SelectedIndexChanged += comboBox1_SelectedIndexChanged;
            // 
            // buttonOrder
            // 
            buttonOrder.AllowDrop = true;
            buttonOrder.Location = new Point(595, 27);
            buttonOrder.Name = "buttonOrder";
            buttonOrder.Size = new Size(116, 23);
            buttonOrder.TabIndex = 8;
            buttonOrder.Text = "Ordenar Por dias";
            buttonOrder.UseVisualStyleBackColor = true;
            buttonOrder.Click += buttonOrder_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.GradientInactiveCaption;
            ClientSize = new Size(1135, 527);
            Controls.Add(groupBox1);
            Controls.Add(buttonOrder);
            Controls.Add(comboBOrder);
            Controls.Add(btDale);
            Controls.Add(tBRuta);
            Controls.Add(btFinder);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            groupBox1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)dataGridView1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private OpenFileDialog openFD;
        private Button btFinder;
        private TextBox tBRuta;
        private Button btDale;
        private ComboBox comboBOrder;
        private Button buttonOrder;
        private DataGridView dataGridView1;
    }
}
