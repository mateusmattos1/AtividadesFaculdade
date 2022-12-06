using System;
using System.Collections.Generic;
using System.Text;

namespace Conversor.Entities
{
    public class Financiamento
    {
        public Financiamento(string inscricaoEstadual, string mesCont, string mesFat, string anoCont, string anoBase, string vlrICMS, string vlrFinanciamento, string razaoSocial)
        {
            this.inscricaoEstadual = inscricaoEstadual;
            this.mesCont = mesCont;
            this.mesFat = mesFat;
            this.anoFat = anoFat;
            this.anoCont = anoCont;
            this.vlrICMS = vlrICMS;
            this.vlrFinanciamento = vlrFinanciamento;
            this.razaoSocial = razaoSocial;
        }

        public Financiamento()
        {
        }

        public string inscricaoEstadual { get; set; }
        public string mesCont { get; set; }
        public string mesFat { get; set; }
        public string anoFat { get; set; }
        public string anoCont { get; set; }
        public string vlrICMS { get; set; }
        public string vlrFinanciamento { get; set; }
        public string razaoSocial { get; set; }
    }
}
