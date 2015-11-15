STDOUT.sync = true # DO NOT REMOVE
# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.


# game loop
loop do
  space_x, space_y = gets.split(" ").collect {|x| x.to_i}

  mountain_X = 0
  maxMountain_H = 0

  8.times do |i|
    mountain_h = gets.to_i # represents the height of one mountain, from 9 to 0. Mountain heights are provided from left to right.
    if mountain_h > maxMountain_H
      mountain_X = i
      maxMountain_H = mountain_h
    end
  end

  # Write an action using puts
  # To debug: STDERR.puts "Debug messages..."

  if mountain_X == space_x
    puts 'FIRE'
  else
    puts 'HOLD' # either:  FIRE (ship is firing its phase cannons) or HOLD (ship is not firing).
  end

end