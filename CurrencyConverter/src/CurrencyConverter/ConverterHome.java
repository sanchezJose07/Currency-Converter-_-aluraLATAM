package CurrencyConverter;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

class ConverterHome{
    public static void main(String[] args) {
        Converter converter = new Converter();
        DecimalFormat df = new DecimalFormat("#.##");

        do{
            try{
                converter.setOption((JOptionPane.showInputDialog(null, "Select the type of converter", "Currency-Temperature-Converter", JOptionPane.QUESTION_MESSAGE, null,  converter.getConversionType(),converter.getConversionType()[0])).toString());
                converter.setExchange((JOptionPane.showInputDialog(null, "How do you want the conversion?", ""+converter.getOption()+" Converter", JOptionPane.QUESTION_MESSAGE, null,  converter.selection(),converter.selection()[0])).toString());
                //converter.setIsAnInteger(false);
                do{
                    try{
                        converter.setValor(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the "+converter.getOption()+" ("+converter.getExchange()+"): ",converter.getOption()+" _ "+converter.getExchange(),JOptionPane.QUESTION_MESSAGE)));
                        converter.setIsAnInteger(true);
                        System.out.println(converter.getIsAnInteger());
                    }catch(NumberFormatException exception){
                        converter.setIsAnInteger(false);
                        converter.setErrorNoInt(JOptionPane.showOptionDialog(null,"No real number has been entered!","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,converter.getAdvertencia(),converter.getAdvertencia()[0]));
                        if(converter.getErrorNoInt() == JOptionPane.NO_OPTION || converter.getErrorNoInt()==JOptionPane.CLOSED_OPTION){
                            converter.setWarning(JOptionPane.NO_OPTION);
                        }
                        System.out.println(converter.getIsAnInteger());
                    }
                }while(converter.getErrorNoInt()==JOptionPane.YES_OPTION && converter.getIsAnInteger() == false);

                if (converter.getIsAnInteger() == true){
                    JOptionPane.showMessageDialog(null,df.format(converter.getValor())+" "+converter.getExchange()+" is:  "+df.format(converter.exchangeValor(converter.getExchange(),converter.getValor())),converter.getOption()+" _ "+converter.getExchange(), JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NullPointerException exception){
                converter.setWarning(JOptionPane.showOptionDialog(null, "You want to leave", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, converter.getAdvertencia(), converter.getAdvertencia()[0]));
            }
        }while(converter.getWarning() == JOptionPane.YES_OPTION);
    }        
}