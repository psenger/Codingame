STDOUT.sync = true # DO NOT REMOVE
# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.
# ---
# Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.

# light_x: the X position of the light of power
# light_y: the Y position of the light of power
# initial_tx: Thor's starting X position
# initial_ty: Thor's starting Y position
@light_x, @light_y, @initial_tx, @initial_ty = gets.split(" ").collect {|x| x.to_i}

thor_X = @initial_tx
thor_Y = @initial_ty
# game loop
loop do
  remaining_turns = gets.to_i # The remaining amount of turns Thor can move. Do not remove this line.

  # Write an action using puts
  # To debug: STDERR.puts "Debug messages..."

  direction_X = ''
  direction_Y = ''



  if thor_X > @light_x
    direction_X = 'W'
    thor_X = thor_X - 1
  elsif thor_X < @light_x then
    direction_X = 'E'
    thor_X = thor_X + 1
  end

  if thor_Y > @light_y
    direction_Y = 'N'
    thor_Y = thor_Y - 1
  elsif thor_Y < @light_y then
    direction_Y = 'S'
    thor_Y = thor_Y + 1
  end

  puts direction_Y + direction_X  # A single line providing the move to be made: N NE E SE S SW W or NW

end