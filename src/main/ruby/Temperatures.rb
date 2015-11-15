# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

def convert_To_Int( string_of_ints )
  string_of_ints.split(" ").map { |s| s.to_i }
end

@n = gets.to_i # the number of temperatures to analyse
@temps = gets.chomp # the n temperatures expressed as integers ranging from -273 to 5526

min = 0
if @n > 0
  all_temps = convert_To_Int( @temps )
  min = 5526
  all_temps.each { |all_temp|
    if all_temp.abs < min.abs
      min = all_temp
    elsif all_temp.abs == min.abs
      if all_temp < min
        min = min
      elsif all_temp > min
        min = all_temp
      end
    end
  }
else
  min = 0
end
puts min