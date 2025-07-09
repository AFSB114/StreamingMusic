import { TextInput, View } from 'react-native';

export default function CustomInput({
  label,
  handleChange,
  field,
  placeholder,
  secureTextEntry,
  ...props
}: {
  label: string;
  handleChange: (text: string) => void;
  field: string;
  placeholder: string;
  secureTextEntry: boolean;
}) {
  return(
    <View>
      <TextInput
        {...props}
        placeholder={placeholder}
        secureTextEntry={secureTextEntry}
        onChangeText={() => console.log('onChangeText')}
      />
    </View>
  );
}
