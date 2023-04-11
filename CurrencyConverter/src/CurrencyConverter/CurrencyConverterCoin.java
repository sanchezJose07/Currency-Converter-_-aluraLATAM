package CurrencyConverter;

public class CurrencyConverterCoin {
    private int position;
    private double valor;
    private double currency;
    private double[] pesoExchange = {0.055,0.074,0.044,0.051,72.75,7.35,18.16,1.35,0.81,0.92,1320.30,133.28};
    private String pesoMX = "Peso Mexicano";
    private String dollarUSA = "USA Dollar";
    private String[] peso = {pesoMX+" - "+dollarUSA,pesoMX+" - Dolar Canadiense",pesoMX+" - Libra Esterlina",pesoMX+" - Euro",pesoMX+" - Won",pesoMX+" - yen"};
    private String[] dollar = {dollarUSA+" - "+pesoMX,dollarUSA+" - Canadian Dollar",dollarUSA+" - British Pound Sterling", dollarUSA+" - Euro",dollarUSA+" - Won",dollarUSA+" - Yen"};
    private String[] exchangeType = new String[peso.length+dollar.length]; 

    public String[] getExchangeType() {Menu(); return exchangeType;  }

    private void Menu(){
        System.arraycopy(peso, 0,exchangeType, 0,peso.length);
        System.arraycopy(dollar, 0, exchangeType, peso.length, dollar.length);
    }
    
    public double transformation(String cambio,double valor){
        this.valor = valor;
        for(int i=0;i<=exchangeType.length;i++)
            if(cambio == exchangeType[i]){
                this.position = i;
                break;
            }
        this.currency = this.valor*pesoExchange[this.position];
        return currency;
    }
}
