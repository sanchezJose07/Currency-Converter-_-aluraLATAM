package CurrencyConverter;

public class TemperatureConverter {
    private double temperature;
    private double valor;
    private int position;
    private String[] exchangeType = {"Celcius - Fahrenheit","Celcius - Kelvin","Fahrenheit - Celcius", "Fahrenheit - Kelvin","Kelvin - Celcius","Kelvin - Fahrenheit"};

    public String[] getExchangeType() {return exchangeType;}

    private void value(){
        switch(position){
            case 1://"Celcius - Fahrenheit"
                this.temperature = this.valor*1.8+32;
                break;
            case 2://"Celcius - Kelvin"
                this.temperature = this.valor+273.15;
                break;
            case 3://"Fahrenheit - Celcius"
                this.temperature = (this.valor-32)/1.8;
                break;
            case 4://"Fahrenheit - Kelvin"
                this.temperature = 5*((this.valor)+459.67)/9;
                break;
            case 5://"Kelvin - Celcius"
                this.temperature = this.valor - 273.15;
                break;
            case 6://"Kelvin - Fahrenheit"
                this.temperature = 1.8*(this.valor-273.15)+32;
                break;
            default:
                this.temperature = 0.0;
                break;
        }
    }
    public double transformation(String cambio,double valor){
        this.valor = valor;
        for(int i=0;i<=exchangeType.length;i++)
            if(cambio == exchangeType[i]){
                position = i+1;
                break;
            }
        value();
        return temperature;
    }
}
