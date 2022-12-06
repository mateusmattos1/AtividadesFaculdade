using System;
using Oracle.ManagedDataAccess.Client;
using ClosedXML.Excel;
using System.Linq;
using System.Collections.Generic;
using Conversor.Entities;
using System.IO;

namespace Converter
{
    class Program
    {
        static void Main(String[] args)
        {

            const string sql = "STRING DE CONEXAO EM ORACLE CENSURADA";

            // Lista de financiamento
            List<Financiamento> financs = new List<Financiamento>();

            //Abrir arquivo excel
            var xls = new XLWorkbook(@"ENTRADA DO ARQUIVO CENSURADA");
            var planilha = xls.Worksheets.First(w => w.Name == "Plan1");
            var totalLinhas = planilha.Rows().Count();

            for (int i = 2; i <= totalLinhas; i++)
            {
                // Variavel de financiamento
                Financiamento financ = new Financiamento();

                var cnpj = planilha.Cell($"A{i}").Value.ToString();
                cnpj = String.Join("", System.Text.RegularExpressions.Regex.Split(cnpj, @"[^\d]"));
                cnpj = "'" + cnpj + "'";

                // Pesquisa no banco
                using (OracleConnection conn = new OracleConnection(sql))
                {
                    conn.Open();
                    using (var command = new OracleCommand())
                    {
                        command.Connection = conn;
                        command.CommandType = System.Data.CommandType.Text;
                        string busca = "CONSULTA EM BANCO CENSURADA" + cnpj;
                        command.CommandText = busca;

                        var reader = command.ExecuteReader();
                        string resultado;
                        while (reader.Read())
                        {
                            resultado = reader.GetString(0);
                            financ.inscricaoEstadual = resultado;
                        }                        
                    }
                    conn.Close();
                }

                financ.razaoSocial = planilha.Cell($"B{i}").Value.ToString();

                string vlrFinanciamento = planilha.Cell($"C{i}").Value.ToString();

                vlrFinanciamento = ValidarNumero(vlrFinanciamento);
                vlrFinanciamento = String.Join("", System.Text.RegularExpressions.Regex.Split(vlrFinanciamento, @"[^\d]"));
                financ.vlrFinanciamento = vlrFinanciamento;

                string vlrICMS = planilha.Cell($"D{i}").Value.ToString();
                vlrICMS = ValidarNumero(vlrICMS);
                vlrICMS = String.Join("", System.Text.RegularExpressions.Regex.Split(vlrICMS, @"[^\d]"));
                financ.vlrICMS = vlrICMS;

                string[] datFat = planilha.Cell($"E{i}").Value.ToString().Split("/");
                financ.anoFat = datFat[2].Split(" ")[0].ToString();
                financ.mesFat = datFat[1].ToString();

                string[] datCont = planilha.Cell($"F{i}").Value.ToString().Split("/");
                financ.anoCont = datCont[2].Split(" ")[0].ToString();
                financ.mesCont = datCont[1].ToString();

                financs.Add(financ);
            }

            // Gerar txt
            int tamanhoRazaoSocial = 50;
            int tamanhoValores = 15;

            string saidaTxt = @"SAÍDA DE ARQUIVO CENSURADA";

            using (StreamWriter sw = File.CreateText(saidaTxt))
            {
                foreach (Financiamento financ in financs)
                {
                    // Campo razao social
                    if (financ.razaoSocial.Length > 50)
                    {
                        financ.razaoSocial = financ.razaoSocial.Substring(0, 50) + ";";
                    }
                    else if (financ.razaoSocial.Length < 50)
                    {
                        financ.razaoSocial = PreencherEspaco(financ.razaoSocial) + ";";
                    }
                    else
                    {
                        financ.razaoSocial += ";";
                    }

                    // Campo inscrição estadual
                    if (String.IsNullOrEmpty(financ.inscricaoEstadual))
                    {
                        financ.inscricaoEstadual = "---------";
                    }
                    financ.inscricaoEstadual += "    ;";

                    // Campo valor financiamento
                    financ.vlrFinanciamento = PreencherZeros(financ.vlrFinanciamento) + ";";

                    // Campo valor ICMS
                    financ.vlrICMS = PreencherZeros(financ.vlrICMS) + "#";

                    // Data faturamento
                    financ.mesFat += ";";
                    financ.anoFat = financ.anoFat + ";";

                    // Data contrato
                    financ.mesCont += ";";
                    financ.anoCont += ";";

                    sw.Write(financ.razaoSocial + financ.inscricaoEstadual + financ.mesFat + financ.anoFat + financ.mesCont + financ.anoCont + financ.vlrFinanciamento + financ.vlrICMS + "\n");
                }
            }
        }

        private static string ValidarNumero(string numero)
        {
            var strings = numero.Split(',');
            if (strings[1].ToString().Length == 1)
            {
                return numero + "0";
            }
            return numero;
        }

        private static string PreencherEspaco(string param)
        {
            int dif = 50 - param.Length;
            for (int i = 0; i < dif; i++)
            {
                param += " ";
            }
            return param;
        }

        private static string PreencherZeros(string numero)
        {
            if (numero.Length == 15)
            {
                return numero;
            }
            int diff = 15 - numero.Length;

            for (int i = 0; i < diff; i++)
            {
                numero = "0" + numero;
            }

            return numero;
        }

        private static string TransformarMes(string extenso)
        {
            if (extenso.Equals("jan"))
            {
                return ("01");
            }
            if (extenso.Equals("fev"))
            {
                return ("02");
            }
            if (extenso.Equals("mar"))
            {
                return ("03");
            }
            if (extenso.Equals("abr"))
            {
                return ("04");
            }
            if (extenso.Equals("mai"))
            {
                return ("05");
            }
            if (extenso.Equals("jun"))
            {
                return ("06");
            }
            if (extenso.Equals("jul"))
            {
                return ("07");
            }
            if (extenso.Equals("ago"))
            {
                return ("08");
            }
            if (extenso.Equals("set"))
            {
                return ("09");
            }
            if (extenso.Equals("out"))
            {
                return ("10");
            }
            if (extenso.Equals("nov"))
            {
                return ("11");
            }
            if (extenso.Equals("dez"))
            {
                return ("12");
            }
            return null;
        }
    }
}