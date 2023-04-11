package CurrencyConverter;

public class Converter {
    private boolean isAnInteger;
    private int errorNoInt;
    private String option;
    private String exchange;
    private int warning;
    private double valor;
    private double finalValor;
    private Object[] conversionType = {"Currency", "Temperature"};
    private String[] advertencia = {"Continue", "Exit"};
    private CurrencyConverterCoin currencyConverter = new CurrencyConverterCoin();
    private TemperatureConverter temperatureConverter = new TemperatureConverter();

    public void setIsAnInteger(boolean seHaIntroducidoEntero) {this.isAnInteger = seHaIntroducidoEntero;}
    public boolean getIsAnInteger(){return this.isAnInteger;}
    public String getOption() {return option;}
    public void setOption(String option) {this.option = option;}
    public String getExchange() {return exchange;}
    public void setExchange(String exchange) {this.exchange = exchange;}
    public void setWarning(int warning) {this.warning = warning;}
    public int getWarning() {return warning;}
    public int getErrorNoInt() {return errorNoInt;}
    public void setErrorNoInt(int errorNoInt) {this.errorNoInt = errorNoInt;}
    public double getValor() {return valor;}
    public void setValor(double valor) {this.valor = valor;}
    public String[] getAdvertencia() {return advertencia;}
    public Object[] getConversionType() {return conversionType;}
    
    public String[] selection(){
        if(option == conversionType[0])
            return currencyConverter.getExchangeType();
        else if(option == conversionType[1]){
            System.out.println("No fue logrado");
            return temperatureConverter.getExchangeType();
        }
        else {
            return advertencia;
        }
    }
    public double exchangeValor(String cambio,double valor){
        if(option == conversionType[0])
            finalValor = currencyConverter.transformation(cambio,valor);
        else if(option == conversionType[1])
            finalValor = temperatureConverter.transformation(cambio,valor);
        return finalValor;
    }




    
}
