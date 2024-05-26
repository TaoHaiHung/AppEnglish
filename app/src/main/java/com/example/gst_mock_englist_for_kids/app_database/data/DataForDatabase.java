package com.example.gst_mock_englist_for_kids.app_database.data;

import android.content.Context;


import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.look_and_choose.model.ImageAnswer;
import com.example.gst_mock_englist_for_kids.app_client.listen_and_guess.model.ListenAnswer;
import com.example.gst_mock_englist_for_kids.app_client.topic.model.Topic;
import com.example.gst_mock_englist_for_kids.app_client.topic_detail.model.TopicDetails;
import com.example.gst_mock_englist_for_kids.app_database.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.app_database.create_database.Database;

import java.util.ArrayList;
import java.util.List;


public final class DataForDatabase {

    private final Context mContext;

    private Database mDatabase;

    public DataForDatabase(Context mContext) {

        this.mContext = mContext;
    }

    public void addDataTopicTable() {
        final List<Topic> list = new ArrayList<>();
        list.add(new Topic(1, mContext.getResources().getString(R.string.alphabet), "img_topic/alphabet.png"));
        list.add(new Topic(2, mContext.getResources().getString(R.string.number), "img_topic/number.png"));
        list.add(new Topic(3, mContext.getResources().getString(R.string.animal), "img_topic/animal.png"));
        list.add(new Topic(4, mContext.getResources().getString(R.string.christmas), "img_topic/christmas.png"));
        list.add(new Topic(5, mContext.getResources().getString(R.string.color), "img_topic/color.png"));
        list.add(new Topic(6, mContext.getResources().getString(R.string.food), "img_topic/food.png"));
        list.add(new Topic(7, mContext.getResources().getString(R.string.fruit), "img_topic/fruit.png"));
        list.add(new Topic(8, mContext.getResources().getString(R.string.flower), "img_topic/flower.png"));
        list.add(new Topic(9, mContext.getResources().getString(R.string.geometry), "img_topic/geometry.png"));
        list.add(new Topic(10, mContext.getResources().getString(R.string.house), "img_topic/house.png"));
        list.add(new Topic(11, mContext.getResources().getString(R.string.nation), "img_topic/nation.png"));
        list.add(new Topic(12, mContext.getResources().getString(R.string.school), "img_topic/school.png"));
        list.add(new Topic(13, mContext.getResources().getString(R.string.vehicle), "img_topic/vehicle.png"));
        list.add(new Topic(14, mContext.getResources().getString(R.string.water), "img_topic/water.png"));

        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDatabase = Database.getInstance(mContext);
                mDatabase.iTopicDao().insertTopic(list);
            }
        });

    }

    public void addDataTopicDetailsTable() {
        final List<TopicDetails> listDetailTopic = new ArrayList<>();

        /* add data for Alphabet
         *
         **/
        listDetailTopic.add(new TopicDetails(1, "img_alphabet/a.png", "A", 1));
        listDetailTopic.add(new TopicDetails(2, "img_alphabet/b.png", "B", 1));
        listDetailTopic.add(new TopicDetails(3, "img_alphabet/c.png", "C", 1));
        listDetailTopic.add(new TopicDetails(4, "img_alphabet/d.png", "D", 1));
        listDetailTopic.add(new TopicDetails(5, "img_alphabet/e.png", "E", 1));
        listDetailTopic.add(new TopicDetails(6, "img_alphabet/f.png", "F", 1));
        listDetailTopic.add(new TopicDetails(7, "img_alphabet/g.png", "G", 1));
        listDetailTopic.add(new TopicDetails(8, "img_alphabet/h.png", "H", 1));
        listDetailTopic.add(new TopicDetails(9, "img_alphabet/i.png", "I", 1));
        listDetailTopic.add(new TopicDetails(10, "img_alphabet/j.png", "J", 1));
        listDetailTopic.add(new TopicDetails(11, "img_alphabet/k.png", "K", 1));
        listDetailTopic.add(new TopicDetails(12, "img_alphabet/l.png", "L", 1));
        listDetailTopic.add(new TopicDetails(13, "img_alphabet/m.png", "M", 1));
        listDetailTopic.add(new TopicDetails(14, "img_alphabet/n.png", "N", 1));
        listDetailTopic.add(new TopicDetails(15, "img_alphabet/o.png", "O", 1));
        listDetailTopic.add(new TopicDetails(16, "img_alphabet/p.png", "P", 1));
        listDetailTopic.add(new TopicDetails(17, "img_alphabet/q.png", "Q", 1));
        listDetailTopic.add(new TopicDetails(18, "img_alphabet/r.png", "R", 1));
        listDetailTopic.add(new TopicDetails(19, "img_alphabet/s.png", "S", 1));
        listDetailTopic.add(new TopicDetails(20, "img_alphabet/t.png", "T", 1));
        listDetailTopic.add(new TopicDetails(21, "img_alphabet/u.png", "U", 1));
        listDetailTopic.add(new TopicDetails(22, "img_alphabet/v.png", "V", 1));
        listDetailTopic.add(new TopicDetails(23, "img_alphabet/w.png", "W", 1));
        listDetailTopic.add(new TopicDetails(24, "img_alphabet/x.png", "X", 1));
        listDetailTopic.add(new TopicDetails(25, "img_alphabet/y.png", "Y", 1));
        listDetailTopic.add(new TopicDetails(26, "img_alphabet/z.png", "Z", 1));


        //add data for Number

        listDetailTopic.add(new TopicDetails(27, "img_number/zero.png", "Zero", 2));
        listDetailTopic.add(new TopicDetails(28, "img_number/one.png", "One", 2));
        listDetailTopic.add(new TopicDetails(29, "img_number/two.png", "Two", 2));
        listDetailTopic.add(new TopicDetails(30, "img_number/three.png", "Three", 2));
        listDetailTopic.add(new TopicDetails(31, "img_number/four.png", "Four", 2));
        listDetailTopic.add(new TopicDetails(32, "img_number/five.png", "Five", 2));
        listDetailTopic.add(new TopicDetails(33, "img_number/six.png", "Six", 2));
        listDetailTopic.add(new TopicDetails(34, "img_number/seven.png", "Seven", 2));
        listDetailTopic.add(new TopicDetails(35, "img_number/eight.png", "Eight", 2));
        listDetailTopic.add(new TopicDetails(36, "img_number/nine.png", "Nine", 2));
        listDetailTopic.add(new TopicDetails(37, "img_number/ten.png", "Ten", 2));
        listDetailTopic.add(new TopicDetails(38, "img_number/eleven.png", "Eleven", 2));
        listDetailTopic.add(new TopicDetails(39, "img_number/twelve.png", "Twelve", 2));
        listDetailTopic.add(new TopicDetails(40, "img_number/thirteen.png", "Thirteen", 2));
        listDetailTopic.add(new TopicDetails(41, "img_number/fourteen.png", "Fourteen", 2));
        listDetailTopic.add(new TopicDetails(42, "img_number/fifteen.png", "Fifteen", 2));
        listDetailTopic.add(new TopicDetails(43, "img_number/sixteen.png", "Sixteen", 2));
        listDetailTopic.add(new TopicDetails(44, "img_number/seventeen.png", "Seventeen", 2));
        listDetailTopic.add(new TopicDetails(45, "img_number/eighteen.png", "Eighteen", 2));
        listDetailTopic.add(new TopicDetails(46, "img_number/nineteen.png", "Nineteen", 2));
        listDetailTopic.add(new TopicDetails(47, "img_number/twenty.png", "Twenty", 2));

        /*
         * add Data for animal
         * **/
        listDetailTopic.add(new TopicDetails(48, "img_animal/bear.png", "Bear", 3));
        listDetailTopic.add(new TopicDetails(49, "img_animal/elephant.png", "Elephant", 3));
        listDetailTopic.add(new TopicDetails(50, "img_animal/hippo.png", "Hippo", 3));
        listDetailTopic.add(new TopicDetails(51, "img_animal/leopard.png", "Leopard", 3));
        listDetailTopic.add(new TopicDetails(52, "img_animal/lion.png", "Lion", 3));
        listDetailTopic.add(new TopicDetails(53, "img_animal/mouse.png", "Mouse", 3));
        listDetailTopic.add(new TopicDetails(54, "img_animal/tiger.png", "Tiger", 3));
        listDetailTopic.add(new TopicDetails(55, "img_animal/eagle.png", "Eagle", 3));
        listDetailTopic.add(new TopicDetails(56, "img_animal/parrot.png", "Parrot", 3));
        listDetailTopic.add(new TopicDetails(57, "img_animal/dog.png", "Dog", 3));
        listDetailTopic.add(new TopicDetails(58, "img_animal/cat.png", "Cat", 3));
        listDetailTopic.add(new TopicDetails(59, "img_animal/chicken.png", "Chicken", 3));
        listDetailTopic.add(new TopicDetails(60, "img_animal/pig.png", "Pig", 3));
        listDetailTopic.add(new TopicDetails(61, "img_animal/cow.png", "Cow", 3));
        listDetailTopic.add(new TopicDetails(62, "img_animal/butterfly.png", "Butterfly", 3));


        //add data color
        listDetailTopic.add(new TopicDetails(63, "img_color/black.png", "Black", 5));
        listDetailTopic.add(new TopicDetails(64, "img_color/blue.png", "Blue", 5));
        listDetailTopic.add(new TopicDetails(65, "img_color/brown.png", "Brown", 5));
        listDetailTopic.add(new TopicDetails(66, "img_color/green.png", "Green", 5));
        listDetailTopic.add(new TopicDetails(67, "img_color/red.png", "Red", 5));
        listDetailTopic.add(new TopicDetails(68, "img_color/violet.png", "Violet", 5));
        listDetailTopic.add(new TopicDetails(69, "img_color/white.png", "White", 5));
        listDetailTopic.add(new TopicDetails(70, "img_color/yellow.png", "Yellow", 5));

        //add data for christmas
        listDetailTopic.add(new TopicDetails(71, "img_christmas/angle.png", "Angle", 4));
        listDetailTopic.add(new TopicDetails(72, "img_christmas/christmas_tree.png", "Christmas tree", 4));
        listDetailTopic.add(new TopicDetails(73, "img_christmas/father_christmas.png", "Santa Claus", 4));
        listDetailTopic.add(new TopicDetails(74, "img_christmas/mistletoe.png", "Mistletoe", 4));
        listDetailTopic.add(new TopicDetails(75, "img_christmas/sleigh.png", "Sleigh", 4));
        listDetailTopic.add(new TopicDetails(76, "img_christmas/snowman.png", "Snowman", 4));
        listDetailTopic.add(new TopicDetails(190, "img_christmas/img_bells.png", "Bells", 4));
        listDetailTopic.add(new TopicDetails(191, "img_christmas/img_candles.png", "Candles", 4));
        listDetailTopic.add(new TopicDetails(192, "img_christmas/image_stocking.png", "Stocking", 4));
        listDetailTopic.add(new TopicDetails(193, "img_christmas/img_presents.png", "Presents", 4));
        listDetailTopic.add(new TopicDetails(194, "img_christmas/img_christmas_card.png", "Christmas Card", 4));
        listDetailTopic.add(new TopicDetails(195, "img_christmas/img_candy_canes.png", "Candy Canes", 4));
        //add data for food
        listDetailTopic.add(new TopicDetails(77, "img_food/beef.png", "Beef", 6));
        listDetailTopic.add(new TopicDetails(78, "img_food/bread.png", "Bread", 6));
        listDetailTopic.add(new TopicDetails(79, "img_food/cheese.png", "Cheese", 6));
        listDetailTopic.add(new TopicDetails(80, "img_food/egg.png", "Egg", 6));
        listDetailTopic.add(new TopicDetails(81, "img_food/hotpot.png", "Hotpot", 6));
        listDetailTopic.add(new TopicDetails(82, "img_food/pizza.png", "Pizza", 6));
        listDetailTopic.add(new TopicDetails(83, "img_food/rice.png", "Rice", 6));
        listDetailTopic.add(new TopicDetails(84, "img_food/soup.png", "Soup", 6));


        // add data of flower

        listDetailTopic.add(new TopicDetails(85, "img_flower/rose.png", "Rose", 8));
        listDetailTopic.add(new TopicDetails(86, "img_flower/aster.png", "Aster", 8));
        listDetailTopic.add(new TopicDetails(87, "img_flower/carnation.png", "Carnation", 8));
        listDetailTopic.add(new TopicDetails(88, "img_flower/chrysanthemum.png", "Chrysanthemum", 8));
        listDetailTopic.add(new TopicDetails(89, "img_flower/daffodil.png", "Daffodil", 8));
        listDetailTopic.add(new TopicDetails(90, "img_flower/flax.png", "Flax", 8));
        listDetailTopic.add(new TopicDetails(91, "img_flower/hibiscus.png", "Hibiscus", 8));
        listDetailTopic.add(new TopicDetails(92, "img_flower/lotus.png", "Lotus", 8));
        listDetailTopic.add(new TopicDetails(93, "img_flower/orchid.png", "Orchid", 8));
        listDetailTopic.add(new TopicDetails(94, "img_flower/poppy_flower.png", "Poppy flower", 8));
        listDetailTopic.add(new TopicDetails(95, "img_flower/sun_flower.png", "Sun Flower", 8));
        listDetailTopic.add(new TopicDetails(96, "img_flower/tulip.png", "Tulip", 8));

        // add data for fruit

        listDetailTopic.add(new TopicDetails(97, "img_fruit/apple.png", "Apple", 7));
        listDetailTopic.add(new TopicDetails(98, "img_fruit/orange.png", "Orange", 7));
        listDetailTopic.add(new TopicDetails(99, "img_fruit/jack_fruit.png", "Jack Fruit", 7));
        listDetailTopic.add(new TopicDetails(100, "img_fruit/coconut.png", "Coconut", 7));
        listDetailTopic.add(new TopicDetails(101, "img_fruit/kiwi.png", "Kiwi", 7));
        listDetailTopic.add(new TopicDetails(102, "img_fruit/cucumber.png", "Cucumber", 7));
        listDetailTopic.add(new TopicDetails(103, "img_fruit/mangoes.png", "Mangoes", 7));
        listDetailTopic.add(new TopicDetails(104, "img_fruit/strawberries.png", "Strawberry", 7));
        listDetailTopic.add(new TopicDetails(105, "img_fruit/watermelon.png", "Watermelon", 7));
        listDetailTopic.add(new TopicDetails(106, "img_fruit/eggplant.png", "Eggplant", 7));
        listDetailTopic.add(new TopicDetails(107, "img_fruit/lemon.png", "Lemon", 7));
        listDetailTopic.add(new TopicDetails(108, "img_fruit/banana.png", "Banana", 7));
        listDetailTopic.add(new TopicDetails(109, "img_fruit/pear.png", "Pear", 7));
        listDetailTopic.add(new TopicDetails(110, "img_fruit/grapes.png", "Grapes", 7));
        listDetailTopic.add(new TopicDetails(111, "img_fruit/cherry.png", "Cherry", 7));
        listDetailTopic.add(new TopicDetails(112, "img_fruit/pineapple.png", "Pineapple", 7));
        listDetailTopic.add(new TopicDetails(113, "img_fruit/guava.png", "Guava", 7));
        listDetailTopic.add(new TopicDetails(114, "img_fruit/plums.png", "Plums", 7));

        // add data for geometry
        listDetailTopic.add(new TopicDetails(115, "img_geometry/circle.png", "Circle", 9));
        listDetailTopic.add(new TopicDetails(116, "img_geometry/cross.png", "Cross", 9));
        listDetailTopic.add(new TopicDetails(117, "img_geometry/diamond.png", "Diamond", 9));
        listDetailTopic.add(new TopicDetails(118, "img_geometry/hexagon.png", "Hexagon", 9));
        listDetailTopic.add(new TopicDetails(119, "img_geometry/heart.png", "Heart", 9));
        listDetailTopic.add(new TopicDetails(120, "img_geometry/pentagon.png", "Pentagon", 9));
        listDetailTopic.add(new TopicDetails(121, "img_geometry/pyramid.png", "Pyramid", 9));
        listDetailTopic.add(new TopicDetails(122, "img_geometry/star.png", "Star", 9));
        listDetailTopic.add(new TopicDetails(123, "img_geometry/rectangle.png", "Rectangle", 9));
        listDetailTopic.add(new TopicDetails(124, "img_geometry/square.png", "Square", 9));
        listDetailTopic.add(new TopicDetails(125, "img_geometry/trapezoid.png", "Trapezoid", 9));
        listDetailTopic.add(new TopicDetails(126, "img_geometry/triangle.png", "Triangle", 9));

        // add data for house
        listDetailTopic.add(new TopicDetails(127, "img_house/bed.png", "Bed", 10));
        listDetailTopic.add(new TopicDetails(128, "img_house/bookcase.png", "Bookcase", 10));
        listDetailTopic.add(new TopicDetails(129, "img_house/chair.png", "Chair", 10));
        listDetailTopic.add(new TopicDetails(130, "img_house/table.png", "Table", 10));
        listDetailTopic.add(new TopicDetails(131, "img_house/clock.png", "Clock", 10));
        listDetailTopic.add(new TopicDetails(132, "img_house/chopping_board.png", "Chopping Board", 10));
        listDetailTopic.add(new TopicDetails(133, "img_house/fridge.png", "Fridge", 10));
        listDetailTopic.add(new TopicDetails(134, "img_house/knife.png", "Knife", 10));
        listDetailTopic.add(new TopicDetails(135, "img_house/phone.png", "Phone", 10));
        listDetailTopic.add(new TopicDetails(136, "img_house/picture.png", "Picture", 10));
        listDetailTopic.add(new TopicDetails(137, "img_house/sofa.png", "Sofa", 10));
        listDetailTopic.add(new TopicDetails(138, "img_house/television.png", "Television", 10));

        // add data for school
        listDetailTopic.add(new TopicDetails(139, "img_school/board.png", "Board", 12));
        listDetailTopic.add(new TopicDetails(140, "img_school/book.png", "Book", 12));
        listDetailTopic.add(new TopicDetails(141, "img_school/calendar.png", "Calendar", 12));
        listDetailTopic.add(new TopicDetails(142, "img_school/teacher.png", "Teacher", 12));
        listDetailTopic.add(new TopicDetails(143, "img_school/eraser.png", "Eraser", 12));
        listDetailTopic.add(new TopicDetails(144, "img_school/crayon.png", "Crayon", 12));
        listDetailTopic.add(new TopicDetails(145, "img_school/map.png", "Map", 12));
        listDetailTopic.add(new TopicDetails(146, "img_school/notebook.png", "Notebook", 12));
        listDetailTopic.add(new TopicDetails(147, "img_school/globe.png", "Globe", 12));
        listDetailTopic.add(new TopicDetails(148, "img_school/ruler.png", "Ruler", 12));
        listDetailTopic.add(new TopicDetails(149, "img_school/schoolbag.png", "Schoolbag", 12));
        listDetailTopic.add(new TopicDetails(150, "img_school/pencil.png", "Pencil", 12));

        //add data for vehicle
        listDetailTopic.add(new TopicDetails(151, "img_vehicle/airplane.png", "Airplane", 13));
        listDetailTopic.add(new TopicDetails(152, "img_vehicle/bike.png", "Bike", 13));
        listDetailTopic.add(new TopicDetails(153, "img_vehicle/bus.png", "Bus", 13));
        listDetailTopic.add(new TopicDetails(154, "img_vehicle/car.png", "Car", 13));
        listDetailTopic.add(new TopicDetails(155, "img_vehicle/motorbike.png", "Motorbike", 13));
        listDetailTopic.add(new TopicDetails(156, "img_vehicle/ship.png", "Ship", 13));
        listDetailTopic.add(new TopicDetails(157, "img_vehicle/train.png", "Train", 13));
        listDetailTopic.add(new TopicDetails(158, "img_vehicle/excavator.png", "Excavator", 13));
        listDetailTopic.add(new TopicDetails(159, "img_vehicle/truck.png", "Truck", 13));
        listDetailTopic.add(new TopicDetails(160, "img_vehicle/honda_cbr_1000.png", "Honda CBR 1000", 13));
        listDetailTopic.add(new TopicDetails(161, "img_vehicle/roll_royce.png", "Roll Royce", 13));
        listDetailTopic.add(new TopicDetails(162, "img_vehicle/kawasaki_ninja_h2r.png", "Kawasaki Ninja H2R", 13));

        // add data for nation
        listDetailTopic.add(new TopicDetails(163, "img_nation/argentina.png", "Argentina", 11));
        listDetailTopic.add(new TopicDetails(164, "img_nation/brazil.png", "Brazil", 11));
        listDetailTopic.add(new TopicDetails(165, "img_nation/vietnam.png", "Vietnam", 11));
        listDetailTopic.add(new TopicDetails(166, "img_nation/china.png", "China", 11));
        listDetailTopic.add(new TopicDetails(167, "img_nation/england.png", "England", 11));
        listDetailTopic.add(new TopicDetails(168, "img_nation/germany.png", "Germany", 11));
        listDetailTopic.add(new TopicDetails(169, "img_nation/italian.png", "Italian", 11));
        listDetailTopic.add(new TopicDetails(170, "img_nation/american.png", "American", 11));
        listDetailTopic.add(new TopicDetails(171, "img_nation/japan.png", "Japan", 11));
        listDetailTopic.add(new TopicDetails(172, "img_nation/mexico.png", "Mexico", 11));
        listDetailTopic.add(new TopicDetails(173, "img_nation/thailand.png", "Thailand", 11));
        listDetailTopic.add(new TopicDetails(174, "img_nation/south_africa.png", "South Africa", 11));


        // add data for water

        listDetailTopic.add(new TopicDetails(175, "img_water/alcohol.png", "Alcohol", 14));
        listDetailTopic.add(new TopicDetails(176, "img_water/beer.png", "Beer", 14));
        listDetailTopic.add(new TopicDetails(177, "img_water/chivas.png", "Chivas", 14));
        listDetailTopic.add(new TopicDetails(178, "img_water/coca_cola.png", "Coca-Cola", 14));
        listDetailTopic.add(new TopicDetails(179, "img_water/coffee.png", "Coffee", 14));
        listDetailTopic.add(new TopicDetails(180, "img_water/ding_tea.png", "Ding-Tea", 14));
        listDetailTopic.add(new TopicDetails(181, "img_water/milk_tea.png", "Milk-Tea", 14));
        listDetailTopic.add(new TopicDetails(182, "img_water/pepsi.png", "Pepsi", 14));
        listDetailTopic.add(new TopicDetails(183, "img_water/red_bull.png", "Red Bull", 14));
        listDetailTopic.add(new TopicDetails(184, "img_water/smoothie.png", "Smoothie", 14));
        listDetailTopic.add(new TopicDetails(185, "img_water/tea.png", "Tea", 14));
        listDetailTopic.add(new TopicDetails(186, "img_water/strongbow.png", "Strongbow", 14));


        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDatabase = Database.getInstance(mContext);
                mDatabase.iTopicDao().insertTopicDetails(listDetailTopic);
            }
        });

    }

    public void addDataImageAnswerTable() {
        final List<ImageAnswer> list = new ArrayList<>();
        list.add(new ImageAnswer(1, "img_alphabet/a.png", "A", "B", "C", "D", "A"));
        list.add(new ImageAnswer(2, "img_alphabet/b.png", "A", "C", "B", "D", "B"));
        list.add(new ImageAnswer(3, "img_alphabet/c.png", "C", "B", "A", "D", "C"));
        list.add(new ImageAnswer(4, "img_alphabet/d.png", "A", "D", "C", "B", "D"));
        list.add(new ImageAnswer(5, "img_alphabet/e.png", "Z", "T", "U", "E", "E"));
        list.add(new ImageAnswer(6, "img_alphabet/f.png", "A", "A", "F", "X", "F"));
        list.add(new ImageAnswer(7, "img_alphabet/g.png", "G", "V", "U", "T", "G"));
        list.add(new ImageAnswer(8, "img_alphabet/h.png", "A", "H", "Y", "W", "H"));
        list.add(new ImageAnswer(9, "img_alphabet/j.png", "T", "W", "Z", "J", "J"));
        list.add(new ImageAnswer(10, "img_alphabet/k.png", "F", "B", "K", "A", "K"));
        list.add(new ImageAnswer(11, "img_alphabet/l.png", "V", "L", "T", "Z", "L"));
        list.add(new ImageAnswer(12, "img_alphabet/m.png", "Q", "P", "C", "M", "M"));
        list.add(new ImageAnswer(13, "img_alphabet/n.png", "N", "L", "H", "O", "N"));
        list.add(new ImageAnswer(14, "img_alphabet/o.png", "K", "W", "O", "B", "O"));
        list.add(new ImageAnswer(15, "img_alphabet/p.png", "P", "Q", "T", "V", "P"));
        list.add(new ImageAnswer(16, "img_alphabet/q.png", "G", "F", "A", "Q", "Q"));
        list.add(new ImageAnswer(17, "img_alphabet/r.png", "I", "R", "S", "T", "R"));
        list.add(new ImageAnswer(18, "img_alphabet/s.png", "C", "F", "S", "E", "S"));
        list.add(new ImageAnswer(19, "img_alphabet/r.png", "G", "R", "V", "A", "R"));
        list.add(new ImageAnswer(20, "img_alphabet/u.png", "O", "N", "M", "U", "U"));
        list.add(new ImageAnswer(21, "img_alphabet/v.png", "F", "Q", "V", "C", "V"));
        list.add(new ImageAnswer(22, "img_alphabet/w.png", "Z", "W", "H", "A", "W"));
        list.add(new ImageAnswer(23, "img_alphabet/x.png", "X", "Y", "Z", "V", "X"));
        list.add(new ImageAnswer(24, "img_alphabet/y.png", "Y", "M", "K", "D", "Y"));
        list.add(new ImageAnswer(25, "img_alphabet/z.png", "X", "A", "W", "Z", "Z"));

        list.add(new ImageAnswer(26, "img_number/one.png", "One", "Nine", "Six", "Ten", "One"));
        list.add(new ImageAnswer(27, "img_number/two.png", "Six", "Eighteen", "Two", "Ten", "Two"));
        list.add(new ImageAnswer(28, "img_number/three.png", "Twenty", "Three", "Cow", "Duck", "Three"));
        list.add(new ImageAnswer(29, "img_number/four.png", "Tri", "Seven", "Nine", "Four", "Four"));
        list.add(new ImageAnswer(30, "img_number/five.png", "Girl", "Five", "AAA", "BB", "Five"));
        list.add(new ImageAnswer(31, "img_number/six.png", "Six", "Baby", "Love", "Ten", "Six"));
        list.add(new ImageAnswer(32, "img_number/seven.png", "Messi", "Kiss", "Seven", "Thirteen", "Seven"));
        list.add(new ImageAnswer(33, "img_number/eight.png", "Eight", "Nine", "Ten", "Soccer", "Eight"));
        list.add(new ImageAnswer(34, "img_number/nine.png", "Sexy", "Bae", "Nine", "Six", "Nine"));
        list.add(new ImageAnswer(35, "img_number/ten.png", "Two", "Ten", "More", "Speed", "Ten"));
        list.add(new ImageAnswer(36, "img_number/eleven.png", "Eleven", "Nine", "Nam", "Trí", "Eleven"));
        list.add(new ImageAnswer(37, "img_number/twelve.png", "Anh", "Iu", "Ơi", "Twelve", "Twelve"));
        list.add(new ImageAnswer(38, "img_number/thirteen.png", "Fourteen", "Thirteen", "Eighteen", "Twenty", "Thirteen"));
        list.add(new ImageAnswer(39, "img_number/fourteen.png", "Five", "Fifteen", "Six", "Fourteen", "Fourteen"));
        list.add(new ImageAnswer(40, "img_number/fifteen.png", "Cat", "Dog", "Hippo", "Fifteen", "Fifteen"));
        list.add(new ImageAnswer(41, "img_number/sixteen.png", "Rectangle", "Circle", "Sixteen", "Sun", "Sixteen"));
        list.add(new ImageAnswer(42, "img_number/seventeen.png", "Nam", "Nine", "Three", "Seventeen", "Seventeen"));
        list.add(new ImageAnswer(43, "img_number/eighteen.png", "Lionel", "Eighteen", "Đậu", "Bye", "Eighteen"));
        list.add(new ImageAnswer(44, "img_number/nineteen.png", "Nineteen", "Nice", "Take", "Need", "Nineteen"));
        list.add(new ImageAnswer(45, "img_number/twenty.png", "Tooth", "Twelve", "Twenty", "Ten", "Twenty"));

        list.add(new ImageAnswer(46, "img_animal/bear.png", "Bear", "Elephant", "Eagle", "Tiger", "Bear"));
        list.add(new ImageAnswer(47, "img_animal/elephant.png", "Cat", "Elephant", "Eagle", "Dog", "Elephant"));
        list.add(new ImageAnswer(48, "img_animal/hippo.png", "Cow", "Parrot", "Hippo", "Tiger", "Hippo"));
        list.add(new ImageAnswer(49, "img_animal/leopard.png", "Trí", "Leopard", "Eagle", "Nam", "Leopard"));
        list.add(new ImageAnswer(50, "img_animal/lion.png", "Trí", "Butterfly", "Mouse", "Lion", "Lion"));
        list.add(new ImageAnswer(51, "img_animal/mouse.png", "Mouse", "Cat", "Baby", "Hack", "Mouse"));
        list.add(new ImageAnswer(52, "img_animal/tiger.png", "Tiger", "Tine", "Tie", "The", "Tiger"));
        list.add(new ImageAnswer(53, "img_animal/eagle.png", "Egg", "Elephant", "Eagle", "Eat", "Eagle"));
        list.add(new ImageAnswer(54, "img_animal/parrot.png", "Phil", "Pax", "Parrot", "Papa", "Parrot"));
        list.add(new ImageAnswer(55, "img_animal/dog.png", "Dog", "Doc", "Local", "Milk", "Dog"));
        list.add(new ImageAnswer(56, "img_animal/cat.png", "Cat", "Chicken", "Care", "Call", "Cat"));
        list.add(new ImageAnswer(57, "img_animal/chicken.png", "Chiu", "Chicken", "Cheese", "Chich", "Chicken"));
        list.add(new ImageAnswer(58, "img_animal/pig.png", "Pink", "Pig", "Pie", "Pi", "Pig"));
        list.add(new ImageAnswer(59, "img_animal/cow.png", "Coca", "Cow", "Cold", "Cỏ", "Cow"));
        list.add(new ImageAnswer(60, "img_animal/butterfly.png", "Butterfly", "Cow", "Eagle", "Tiger", "Butterfly"));

        list.add(new ImageAnswer(61, "img_christmas/angle.png", "Angle", "Father", "Mother", "Haha", "Angle"));
        list.add(new ImageAnswer(62, "img_christmas/christmas_tree.png", "Baby", "Changwook", "Christmas tree", "Hehe", "Christmas tree"));
        list.add(new ImageAnswer(63, "img_christmas/father_christmas.png", "Santa Claus", "Father", "Wrong", "True", "Santa Claus"));
        list.add(new ImageAnswer(64, "img_christmas/mistletoe.png", "Milk", "Miss", "Miss you", "Mistletoe", "Mistletoe"));
        list.add(new ImageAnswer(65, "img_christmas/sleigh.png", "Sleigh", "Slide", "Sing", "Sleep", "Sleigh"));
        list.add(new ImageAnswer(66, "img_christmas/snowman.png", "Slow motion", "Nam", "Snowman", "HandSome", "Snowman"));
        list.add(new ImageAnswer(186, "img_christmas/img_candy_canes.png", "Angle", "Father", "Candy Canes", "Candy", "Candy Canes"));
        list.add(new ImageAnswer(187, "img_christmas/img_christmas_card.png", "Baby", "Christmas Card", "Bens", "Canle", "Christmas Card"));
        list.add(new ImageAnswer(188, "img_christmas/img_presents.png", "Santa Claus", "Father", "Wrong", "Presents", "Presents"));
        list.add(new ImageAnswer(189, "img_christmas/image_stocking.png", "Milk", "Miss", "Stocking", "Mistletoe", "Stocking"));
        list.add(new ImageAnswer(190, "img_christmas/img_bells.png", "Sleigh", "Slide", "Bells", "Sleep", "Bells"));
        list.add(new ImageAnswer(191, "img_christmas/img_candles.png", "Santa Claus", "Candles", "Snowman", "HandSome", "Candles"));

        list.add(new ImageAnswer(67, "img_color/black.png", "Black", "Yellow", "Violet", "Green", "Black"));
        list.add(new ImageAnswer(68, "img_color/blue.png", "Bus", "Yellow", "Blue", "Green", "Blue"));
        list.add(new ImageAnswer(69, "img_color/brown.png", "Green", "White", "Violet", "Brown", "Brown"));
        list.add(new ImageAnswer(70, "img_color/green.png", "Nam", "Green", "Violet", "Trí", "Green"));
        list.add(new ImageAnswer(71, "img_color/red.png", "Red", "Yellow", "Violet", "Black", "Red"));
        list.add(new ImageAnswer(72, "img_color/violet.png", "Black", "Violet", "White", "Green", "Violet"));
        list.add(new ImageAnswer(73, "img_color/white.png", "Black", "White", "Violet", "Green", "White"));
        list.add(new ImageAnswer(74, "img_color/yellow.png", "Black", "Yellow", "Violet", "Green", "Yellow"));

        list.add(new ImageAnswer(75, "img_food/beef.png", "Beef", "Bread", "Cheese", "Egg", "Beef"));
        list.add(new ImageAnswer(76, "img_food/bread.png", "Beef", "Bread", "Cheese", "Egg", "Bread"));
        list.add(new ImageAnswer(77, "img_food/cheese.png", "Beef", "Bread", "Cheese", "Egg", "Cheese"));
        list.add(new ImageAnswer(78, "img_food/egg.png", "Soup", "Bread", "Cheese", "Egg", "Egg"));
        list.add(new ImageAnswer(79, "img_food/hotpot.png", "Hotpot", "Bread", "Ego", "Egg", "Hotpot"));
        list.add(new ImageAnswer(80, "img_food/pizza.png", "Moazz", "Pizza", "Cheese", "Egg", "Pizza"));
        list.add(new ImageAnswer(81, "img_food/rice.png", "Egg", "Bread", "Cheese", "Rice", "Rice"));
        list.add(new ImageAnswer(82, "img_food/soup.png", "Soup", "Bread", "Cheese", "Egg", "Soup"));

        list.add(new ImageAnswer(83, "img_fruit/apple.png", "Apple", "Orange", "Jack Fruit", "Coconut", "Apple"));
        list.add(new ImageAnswer(84, "img_fruit/orange.png", "Apple", "Orange", "Jack Fruit", "Coconut", "Apple"));
        list.add(new ImageAnswer(85, "img_fruit/jack_fruit.png", "Apple", "Orange", "Jack Fruit", "Coconut", "Jack Fruit"));
        list.add(new ImageAnswer(86, "img_fruit/coconut.png", "Apple", "Orange", "Jack Fruit", "Coconut", "Coconut"));
        list.add(new ImageAnswer(87, "img_fruit/kiwi.png", "Watermelon", "Orange", "grapes", "Kiwi", "Kiwi"));
        list.add(new ImageAnswer(88, "img_fruit/cucumber.png", "Sia", "Cucumber", "Cheery", "Orange", "Cucumber"));
        list.add(new ImageAnswer(89, "img_fruit/mangoes.png", "Guava", "Orange", "Mangoes", "Pineapple", "Mangoes"));
        list.add(new ImageAnswer(90, "img_fruit/strawberries.png", "Pear", "Strawberries", "Jack Fruit", "Coconut", "Strawberries"));
        list.add(new ImageAnswer(91, "img_fruit/watermelon.png", "Guava", "Orange", "Grapes", "Watermelon", "Watermelon"));
        list.add(new ImageAnswer(92, "img_fruit/eggplant.png", "Eggplant", "Orange", "Duck", "Beef", "Eggplant"));
        list.add(new ImageAnswer(93, "img_fruit/lemon.png", "Eggplant", "Lemon", "Jack Fruit", "Egg", "Lemon"));
        list.add(new ImageAnswer(94, "img_fruit/banana.png", "Apple", "Banana", "Blade", "Honda", "Banana"));
        list.add(new ImageAnswer(95, "img_fruit/pear.png", "Pear", "Orange", "Mangoes", "Coconut", "Pear"));
        list.add(new ImageAnswer(96, "img_fruit/grapes.png", "Mangoes", "Orange", "Grapes", "Coconut", "Grapes"));
        list.add(new ImageAnswer(97, "img_fruit/cherry.png", "Cherry", "Orange", "Grapes", "Coconut", "Cherry"));
        list.add(new ImageAnswer(98, "img_fruit/pineapple.png", "Plums", "Orange", "Jack Fruit", "Pineapple", "Pineapple"));
        list.add(new ImageAnswer(99, "img_fruit/guava.png", "AAA", "Guava", "Tris", "Coconut", "Guava"));
        list.add(new ImageAnswer(100, "img_fruit/plums.png", "Apple", "Orange", "Plums", "Coconut", "Plums"));

        list.add(new ImageAnswer(101, "img_flower/rose.png", "Sun Flower", "Tulip", "Daffodil", "Rose", "Rose"));
        list.add(new ImageAnswer(102, "img_flower/aster.png", "Sun Flower", "Tulip", "Flax", "Aster", "Aster"));
        list.add(new ImageAnswer(103, "img_flower/carnation.png", "Carnation", "Tulip", "Orchid", "Daffodil", "Carnation"));
        list.add(new ImageAnswer(104, "img_flower/chrysanthemum.png", "Hibiscus", "Chrysanthemum", "Flax", "Aster", "Chrysanthemum"));
        list.add(new ImageAnswer(105, "img_flower/daffodil.png", "Sun Flower", "Tulip", "Flax", "Daffodil", "Daffodil"));
        list.add(new ImageAnswer(106, "img_flower/flax.png", "Hibiscus", "Tulip", "Flax", "Aster", "Flax"));
        list.add(new ImageAnswer(107, "img_flower/hibiscus.png", "Poppy Flower", "Tulip", "Hibiscus", "Aster", "Hibiscus"));
        list.add(new ImageAnswer(108, "img_flower/lotus.png", "Lotus", "Tulip", "Daffodil", "Aster", "Lotus"));
        list.add(new ImageAnswer(109, "img_flower/orchid.png", "Sun Flower", "Tulip", "Orchid", "Aster", "Orchid"));
        list.add(new ImageAnswer(110, "img_flower/poppy_flower.png", "Poppy Flower", "Tulip", "Flax", "Aster", "Poppy Flower"));
        list.add(new ImageAnswer(111, "img_flower/sun_flower.png", "Sun Flower", "Tulip", "Flax", "Aster", "Sun Flower"));
        list.add(new ImageAnswer(112, "img_flower/tulip.png", "Tulip", "Hibiscus", "Flax", "Daffodil", "Tulip"));

        list.add(new ImageAnswer(113, "img_geometry/circle.png", "Triangle", "Circle", "Pyramid", "Pyramid", "Circle"));
        list.add(new ImageAnswer(114, "img_geometry/cross.png", "Cross", "Circle", "Pyramid", "Heart", "Cross"));
        list.add(new ImageAnswer(115, "img_geometry/diamond.png", "Triangle", "Star", "Diamond", "Circle", "Diamond"));
        list.add(new ImageAnswer(116, "img_geometry/hexagon.png", "Hexagon", "Star", "Pyramid", "Heart", "Hexagon"));
        list.add(new ImageAnswer(117, "img_geometry/heart.png", "Triangle", "Circle", "Pyramid", "Heart", "Heart"));
        list.add(new ImageAnswer(118, "img_geometry/pentagon.png", "Triangle", "Hexagon", "Pentagon", "Heart", "Pentagon"));
        list.add(new ImageAnswer(119, "img_geometry/pyramid.png", "Triangle", "Circle", "Pyramid", "Heart", "Pyramid"));
        list.add(new ImageAnswer(120, "img_geometry/star.png", "Triangle", "Circle", "Pyramid", "Star", "Star"));
        list.add(new ImageAnswer(121, "img_geometry/rectangle.png", "Triangle", "Circle", "Rectangle", "Heart", "Rectangle"));
        list.add(new ImageAnswer(122, "img_geometry/square.png", "Square", "Circle", "Pyramid", "Heart", "Square"));
        list.add(new ImageAnswer(123, "img_geometry/trapezoid.png", "Triangle", "Diamond", "Pyramid", "Trapezoid", "Trapezoid"));
        list.add(new ImageAnswer(124, "img_geometry/triangle.png", "Triangle", "Pentagon", "Pyramid", "Heart", "Triangle"));

        list.add(new ImageAnswer(125, "img_house/bed.png", "Sofa", "Bookcase", "Bed", "Phone", "Bed"));
        list.add(new ImageAnswer(126, "img_house/bookcase.png", "Bookcase", "Table", "Bed", "Phone", "Bookcase"));
        list.add(new ImageAnswer(127, "img_house/chair.png", "Sofa", "Table", "Bookcase", "Chair", "Chair"));
        list.add(new ImageAnswer(128, "img_house/table.png", "Television", "Table", "Bed", "Fridge", "Table"));
        list.add(new ImageAnswer(129, "img_house/clock.png", "Clock", "Table", "Bed", "Picture", "Clock"));
        list.add(new ImageAnswer(130, "img_house/chopping_board.png", "Sofa", "Table", "Chopping Board", "Phone", "Chopping Board"));
        list.add(new ImageAnswer(131, "img_house/fridge.png", "Fridge", "Table", "Chopping Board", "Phone", "Fridge"));
        list.add(new ImageAnswer(132, "img_house/knife.png", "Sofa", "Table", "Knife", "Phone", "Knife"));
        list.add(new ImageAnswer(133, "img_house/phone.png", "Sofa", "Chopping Board", "Knife", "Phone", "Phone"));
        list.add(new ImageAnswer(134, "img_house/picture.png", "Sofa", "Table", "Picture", "Chopping Board", "Picture"));
        list.add(new ImageAnswer(135, "img_house/sofa.png", "Chopping Board", "Table", "Bed", "Sofa", "Sofa"));
        list.add(new ImageAnswer(136, "img_house/television.png", "Sofa", "Television", "Chopping Board", "Phone", "Television"));

        list.add(new ImageAnswer(137, "img_nation/argentina.png", "Thailand", "Argentina", "China", "Japan", "Argentina"));
        list.add(new ImageAnswer(138, "img_nation/brazil.png", "Thailand", "South Africa", "China", "Brazil", "Brazil"));
        list.add(new ImageAnswer(139, "img_nation/vietnam.png", "Thailand", "Vietnam", "China", "Japan", "Vietnam"));
        list.add(new ImageAnswer(140, "img_nation/china.png", "England", "Argentina", "China", "Japan", "China"));
        list.add(new ImageAnswer(141, "img_nation/england.png", "Thailand", "Italian", "England", "Japan", "England"));
        list.add(new ImageAnswer(142, "img_nation/germany.png", "Germany", "Argentina", "Mexico", "Japan", "Germany"));
        list.add(new ImageAnswer(143, "img_nation/italian.png", "South Africa", "Italian", "China", "Japan", "Italian"));
        list.add(new ImageAnswer(144, "img_nation/american.png", "Italian", "American", "South Africa", "Japan", "American"));
        list.add(new ImageAnswer(145, "img_nation/japan.png", "Thailand", "Vietnam", "Mexico", "Japan", "Japan"));
        list.add(new ImageAnswer(146, "img_nation/mexico.png", "Vietnam", "Argentina", "Mexico", "Japan", "Mexico"));
        list.add(new ImageAnswer(147, "img_nation/thailand.png", "Thailand", "Mexico", "China", "Japan", "Thailand"));
        list.add(new ImageAnswer(148, "img_nation/south_africa.png", "Mexico", "Argentina", "China", "South Africa", "South Africa"));

        list.add(new ImageAnswer(149, "img_school/board.png", "Pencil", "NoteBook", "Board", "Teacher", "Board"));
        list.add(new ImageAnswer(150, "img_school/book.png", "Pencil", "NoteBook", "Calendar", "Book", "Book"));
        list.add(new ImageAnswer(151, "img_school/calendar.png", "Pencil", "Book", "Calendar", "Book", "Calendar"));
        list.add(new ImageAnswer(152, "img_school/teacher.png", "Eraser", "NoteBook", "Calendar", "Teacher", "Teacher"));
        list.add(new ImageAnswer(153, "img_school/eraser.png", "Pencil", "Book", "Eraser", "Teacher", "Eraser"));
        list.add(new ImageAnswer(154, "img_school/crayon.png", "Crayon", "NoteBook", "Calendar", "Teacher", "Crayon"));
        list.add(new ImageAnswer(155, "img_school/map.png", "Pencil", "Map", "Calendar", "Teacher", "Map"));
        list.add(new ImageAnswer(156, "img_school/notebook.png", "Pencil", "NoteBook", "Calendar", "Globe", "Notebook"));
        list.add(new ImageAnswer(157, "img_school/globe.png", "Globe", "NoteBook", "Calendar", "Schoolbag", "Globe"));
        list.add(new ImageAnswer(158, "img_school/ruler.png", "Pencil", "Ruler", "Calendar", "Teacher", "Ruler"));
        list.add(new ImageAnswer(159, "img_school/schoolbag.png", "Pencil", "NoteBook", "Calendar", "Schoolbag", "Schoolbag"));
        list.add(new ImageAnswer(160, "img_school/pencil.png", "Pencil", "NoteBook", "Calendar", "Schoolbag", "Pencil"));

        list.add(new ImageAnswer(161, "img_vehicle/airplane.png", "Airplane", "Bike", "Truck", "Bus", "Airplane"));
        list.add(new ImageAnswer(162, "img_vehicle/bike.png", "Train", "Bike", "Truck", "Kawasaki ninja h2r", "Bike"));
        list.add(new ImageAnswer(163, "img_vehicle/bus.png", "Train", "Bike", "Truck", "Bus", "Bus"));
        list.add(new ImageAnswer(164, "img_vehicle/car.png", "Train", "Car", "Truck", "Bus", "Car"));
        list.add(new ImageAnswer(165, "img_vehicle/motorbike.png", "Train", "Bike", "Motorbike", "Bus", "Motorbike"));
        list.add(new ImageAnswer(166, "img_vehicle/ship.png", "Train", "Bike", "Truck", "Ship", "Ship"));
        list.add(new ImageAnswer(167, "img_vehicle/train.png", "Train", "Kawasaki ninja h2r", "Truck", "Excavator", "Train"));
        list.add(new ImageAnswer(168, "img_vehicle/excavator.png", "Excavator", "Bike", "Truck", "Bus", "Excavator"));
        list.add(new ImageAnswer(169, "img_vehicle/truck.png", "Train", "Truck", "Truck", "Bus", "Truck"));
        list.add(new ImageAnswer(170, "img_vehicle/honda_cbr_1000.png", "Train", "Bike", "Honda cbr 1000", "Bus", "Honda cbr 1000"));
        list.add(new ImageAnswer(171, "img_vehicle/roll_royce.png", "Roll royce", "Bike", "Truck", "Bus", "Roll royce"));
        list.add(new ImageAnswer(172, "img_vehicle/kawasaki_ninja_h2r.png", "Train", "Bike", "Kawasaki ninja h2r", "Bus", "Kawasaki ninja h2r"));

        list.add(new ImageAnswer(173, "img_water/alcohol.png", "Alcohol", "Coffee", "Milk-Tea", "Chivas", "Alcohol"));
        list.add(new ImageAnswer(174, "img_water/beer.png", "Strongbow", "Beer", "Milk-Coffee", "Chivas", "Beer"));
        list.add(new ImageAnswer(176, "img_water/chivas.png", "Strongbow", "Beer", "Milk-Tea", "Chivas", "Chivas"));
        list.add(new ImageAnswer(176, "img_water/coca_cola.png", "Coffee", "Coca cola", "Milk-Tea", "Chivas", "Coca cola"));
        list.add(new ImageAnswer(177, "img_water/coffee.png", "Strongbow", "Beer", "Milk-Tea", "Coffee", "Coffee"));
        list.add(new ImageAnswer(178, "img_water/ding_tea.png", "Coffee", "Beer", "Milk-Tea", "Ding tea", "Ding tea"));
        list.add(new ImageAnswer(179, "img_water/milk_tea.png", "Strongbow", "Beer", "Milk tea", "Chivas", "Milk tea"));
        list.add(new ImageAnswer(180, "img_water/pepsi.png", "Pepsi", "Beer", "Milk-Tea", "Chivas", "Pepsi"));
        list.add(new ImageAnswer(181, "img_water/red_bull.png", "Strongbow", "Beer", "Red bull", "Chivas", "Red bull"));
        list.add(new ImageAnswer(182, "img_water/smoothie.png", "Coffee", "Smoothie", "Milk-Tea", "Chivas", "Smoothie"));
        list.add(new ImageAnswer(183, "img_water/tea.png", "Strongbow", "Beer", "Milk-Tea", "Tea", "Tea"));
        list.add(new ImageAnswer(184, "img_water/strongbow.png", "Strongbow", "Beer", "Milk-Tea", "Chivas", "Strongbow"));
        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDatabase = Database.getInstance(mContext);
                mDatabase.iTopicDao().insertImageAnswer(list);
            }
        });
    }

    public void addDataListenAnswerTable() {
        final List<ListenAnswer> list = new ArrayList<>();
        list.add(new ListenAnswer(1, "A", "img_alphabet/a.png", "img_animal/chicken.png", "img_christmas/angle.png", "img_color/blue.png", "img_alphabet/a.png"));
        list.add(new ListenAnswer(2, "B", "img_vehicle/truck.png", "img_alphabet/b.png", "img_christmas/christmas_tree.png", "img_color/red.png", "img_alphabet/b.png"));
        list.add(new ListenAnswer(3, "C", "img_alphabet/o.png", "img_alphabet/c.png", "img_nation/germany.png", "img_flower/lotus.png", "img_alphabet/c.png"));
        list.add(new ListenAnswer(4, "D", "img_alphabet/p.png", "img_animal/lion.png", "img_school/map.png", "img_alphabet/d.png", "img_alphabet/d.png"));
        list.add(new ListenAnswer(5, "E", "img_alphabet/s.png", "img_animal/butterfly.png", "img_alphabet/e.png", "img_food/hotpot.png", "img_alphabet/e.png"));
        list.add(new ListenAnswer(6, "F", "img_alphabet/v.png", "img_animal/elephant.png", "img_christmas/sleigh.png", "img_alphabet/f.png", "img_alphabet/f.png"));
        list.add(new ListenAnswer(7, "G", "img_nation/mexico.png", "img_alphabet/g.png", "img_house/phone.png", "img_color/black.png", "img_alphabet/g.png"));
        list.add(new ListenAnswer(8, "H", "img_alphabet/t.png", "img_animal/parrot.png", "img_geometry/triangle.png", "img_alphabet/h.png", "img_alphabet/h.png"));
        list.add(new ListenAnswer(9, "I", "img_alphabet/i.png", "img_animal/cow.png", "img_flower/flax.png", "img_color/blue.png", "img_alphabet/i.png"));
        list.add(new ListenAnswer(10, "J", "img_alphabet/j.png", "img_water/chivas.png", "img_christmas/father_christmas.png", "img_fruit/pear.png", "img_alphabet/j.png"));
        list.add(new ListenAnswer(11, "K", "img_house/knife.png", "img_animal/leopard.png", "img_alphabet/k.png", "img_number/start.png", "img_alphabet/k.png"));
        list.add(new ListenAnswer(12, "L", "img_alphabet/j.png", "img_animal/hippo.png", "img_christmas/angle.png", "img_alphabet/l.png", "img_alphabet/l.png"));
        list.add(new ListenAnswer(13, "M", "img_alphabet/w.png", "img_animal/chicken.png", "img_alphabet/m.png", "img_color/violet.png", "img_alphabet/m.png"));
        list.add(new ListenAnswer(14, "N", "img_alphabet/n.png", "img_fruit/banana.png", "img_vehicle/ship.png", "img_water/smoothie.png", "img_alphabet/n.png"));
        list.add(new ListenAnswer(15, "O", "img_alphabet/q.png", "img_animal/pig.png", "img_christmas/sleigh.png", "img_alphabet/o.png", "img_alphabet/o.png"));
        list.add(new ListenAnswer(16, "P", "img_alphabet/p.png", "img_alphabet/v.png", "img_alphabet/j.png", "img_alphabet/t.png", "img_alphabet/p.png"));
        list.add(new ListenAnswer(17, "Q", "img_alphabet/q.png", "img_alphabet/w.png", "img_alphabet/u.png", "img_nation/china.png", "img_alphabet/q.png"));
        list.add(new ListenAnswer(18, "R", "img_alphabet/a.png", "img_alphabet/b.png", "img_alphabet/c.png", "img_alphabet/r.png", "img_alphabet/r.png"));
        list.add(new ListenAnswer(19, "S", "img_alphabet/z.png", "img_alphabet/s.png", "img_christmas/sleigh.png", "img_school/schoolbag.png", "img_alphabet/s.png"));
        list.add(new ListenAnswer(20, "T", "img_alphabet/v.png", "img_animal/tiger.png", "img_alphabet/t.png", "img_number/thirteen.png", "img_alphabet/t.png"));
        list.add(new ListenAnswer(21, "U", "img_alphabet/q.png", "img_animal/mouse.png", "img_alphabet/u.png", "img_house/phone.png", "img_alphabet/u.png"));
        list.add(new ListenAnswer(22, "V", "img_alphabet/v.png", "img_vehicle/excavator.png", "img_nation/vietnam.png", "img_geometry/triangle.png", "img_alphabet/v.png"));
        list.add(new ListenAnswer(23, "W", "img_alphabet/w.png", "img_alphabet/q.png", "img_alphabet/u.png", "img_fruit/guava.png", "img_alphabet/w.png"));
        list.add(new ListenAnswer(24, "X", "img_alphabet/a.png", "img_animal/butterfly.png", "img_christmas/sleigh.png", "img_alphabet/x.png", "img_alphabet/x.png"));
        list.add(new ListenAnswer(25, "Y", "img_alphabet/i.png", "img_animal/bear.png", "img_alphabet/y.png", "img_vehicle/kawasaki_ninja_h2r.png", "img_alphabet/y.png"));
        list.add(new ListenAnswer(26, "Z", "img_alphabet/x.png", "img_food/pizza.png", "img_number/eighteen.png", "img_alphabet/z.png", "img_alphabet/z.png"));

        list.add(new ListenAnswer(27, "One", "img_number/ten.png", "img_number/one.png", "img_number/sixteen.png", "img_number/eighteen.png", "img_number/one.png"));
        list.add(new ListenAnswer(28, "Two", "img_number/two.png", "img_number/twenty.png", "img_number/nineteen.png", "img_number/sixteen.png", "img_number/two.png"));
        list.add(new ListenAnswer(29, "Three", "img_number/twelve.png", "img_number/twenty.png", "img_number/eleven.png", "img_number/three.png", "img_number/three.png"));
        list.add(new ListenAnswer(30, "Four", "img_number/fourteen.png", "img_number/four.png", "img_number/fifteen.png", "img_number/eight.png", "img_number/four.png"));
        list.add(new ListenAnswer(31, "Five", "img_number/five.png", "img_number/three.png", "img_number/sixteen.png", "img_number/one.png", "img_number/five.png"));
        list.add(new ListenAnswer(32, "Six", "img_number/thirteen.png", "img_number/sixteen.png", "img_number/six.png", "img_number/seven.png", "img_number/six.png"));
        list.add(new ListenAnswer(33, "Seven", "img_number/one.png", "img_number/five.png", "img_number/seven.png", "img_number/seventeen.png", "img_number/seven.png"));
        list.add(new ListenAnswer(34, "Eight", "img_number/eight.png", "img_number/seventeen.png", "img_number/five.png", "img_number/eighteen.png", "img_number/eight.png"));
        list.add(new ListenAnswer(35, "Nine", "img_number/nine.png", "img_number/ten.png", "img_number/nineteen.png", "img_number/three.png", "img_number/nine.png"));
        list.add(new ListenAnswer(36, "Ten", "img_number/two.png", "img_number/one.png", "img_number/ten.png", "img_number/twelve.png", "img_number/ten.png"));
        list.add(new ListenAnswer(37, "Eleven", "img_number/three.png", "img_number/twelve.png", "img_number/three.png", "img_number/eleven.png", "img_number/eleven.png"));
        list.add(new ListenAnswer(38, "Twelve", "img_number/eighteen.png", "img_number/twelve.png", "img_number/six.png", "img_number/", "img_number/twelve.png"));
        list.add(new ListenAnswer(39, "Thirteen", "img_number/thirteen.png", "img_number/fourteen.png", "img_number/fifteen.png", "img_number/sixteen.png", "img_number/thirteen.png"));
        list.add(new ListenAnswer(40, "Fourteen", "img_number/seven.png", "img_number/eighteen.png", "img_number/fifteen.png", "img_number/fourteen.png", "img_number/fourteen.png"));
        list.add(new ListenAnswer(41, "Fifteen", "img_number/eight.png", "img_number/fifteen.png", "img_number/sixteen.png", "img_number/seven.png", "img_number/fifteen.png"));
        list.add(new ListenAnswer(42, "Sixteen", "img_number/nineteen.png", "img_number/sixteen.png", "img_number/seventeen.png", "img_number/nine.png", "img_number/sixteen.png"));
        list.add(new ListenAnswer(43, "Seventeen", "img_number/twenty.png", "img_number/seven.png", "img_number/fourteen.png", "img_number/seventeen.png", "img_number/seventeen.png"));
        list.add(new ListenAnswer(44, "Eighteen", "img_number/eighteen.png", "img_number/nineteen.png", "img_number/seventeen.png", "img_number/eight.png", "img_number/eighteen.png"));
        list.add(new ListenAnswer(45, "Nineteen", "img_number/nineteen.png", "img_number/thirteen.png", "img_number/ten.png", "img_number/nine.png", "img_number/nineteen.png"));
        list.add(new ListenAnswer(46, "Twenty", "img_number/ten.png", "img_number/two.png", "img_number/twenty.png", "img_number/five.png", "img_number/twenty.png"));

        list.add(new ListenAnswer(47, "Bear", "img_animal/hippo.png", "img_animal/pig.png", "img_animal/cow.png", "img_animal/bear.png", "img_animal/bear.png"));
        list.add(new ListenAnswer(48, "Elephant", "img_animal/cow.png", "img_animal/chicken.png", "img_animal/elephant.png", "img_animal/pig.png", "img_animal/elephant.png"));
        list.add(new ListenAnswer(49, "Hippo", "img_animal/butterfly.png", "img_animal/parrot.png", "img_animal/hippo.png", "img_animal/cow.png", "img_animal/hippo.png"));
        list.add(new ListenAnswer(50, "Leopard", "img_animal/lion.png", "img_animal/leopard.png", "img_animal/cow.png", "img_animal/cat.png", "img_animal/leopard.png"));
        list.add(new ListenAnswer(51, "Lion", "img_animal/lion.png", "img_animal/bear.png", "img_animal/tiger.png", "img_animal/cow.png", "img_animal/lion.png"));
        list.add(new ListenAnswer(52, "Mouse", "img_animal/hippo.png", "img_animal/dog.png", "img_animal/cat.png", "img_animal/mouse.png", "img_animal/mouse.png"));
        list.add(new ListenAnswer(53, "Tiger", "img_animal/leopard.png", "img_animal/cat.png", "img_animal/tiger.png", "img_animal/dog.png", "img_animal/tiger.png"));
        list.add(new ListenAnswer(54, "Eagle", "img_animal/elephant.png", "img_animal/eagle.png", "img_animal/parrot.png", "img_animal/chicken.png", "img_animal/eagle.png"));
        list.add(new ListenAnswer(55, "Parrot", "img_animal/cat.png", "img_animal/parrot.png", "img_animal/dog.png", "img_animal/butterfly.png", "img_animal/parrot.png"));
        list.add(new ListenAnswer(56, "Dog", "img_animal/dog.png", "img_animal/cat.png", "img_animal/tiger.png", "img_animal/leopard.png", "img_animal/dog.png"));
        list.add(new ListenAnswer(57, "Cat", "img_animal/cat.png", "img_animal/cow.png", "img_animal/hippo.png", "img_animal/bear.png", "img_animal/cat.png"));
        list.add(new ListenAnswer(58, "Chicken", "img_animal/dog.png", "img_animal/chicken.png", "img_animal/cat.png", "img_animal/hippo.png", "img_animal/chicken.png"));
        list.add(new ListenAnswer(59, "Pig", "img_animal/dog.png", "img_animal/elephant.png", "img_animal/pig.png", "img_animal/chicken.png", "img_animal/pig.png"));
        list.add(new ListenAnswer(60, "Cow", "img_animal/hippo.png", "img_animal/eagle.png", "img_animal/cow.png", "img_animal/parrot.png", "img_animal/cow.png"));
        list.add(new ListenAnswer(61, "Butterfly", "img_animal/bear.png", "img_animal/butterfly.png", "img_animal/dog.png", "img_animal/cow.png", "img_animal/butterfly.png"));

        list.add(new ListenAnswer(62, "Angle", "img_christmas/mistletoe.png", "img_christmas/angle.png", "img_christmas/snowman.png", "img_christmas/sleigh.png", "img_christmas/angle.png"));
        list.add(new ListenAnswer(63, "Christmas tree", "img_christmas/mistletoe.png", "img_christmas/christmas_tree.png", "img_christmas/snowman.png", "img_christmas/angle.png", "img_christmas/christmas_tree.png"));
        list.add(new ListenAnswer(64, "Santa Claus", "img_christmas/sleigh.png", "img_christmas/angle.png", "img_christmas/father_christmas.png", "img_christmas/snowman.png", "img_christmas/father_christmas.png"));
        list.add(new ListenAnswer(65, "Mistletoe", "img_christmas/snowman.png", "img_christmas/sleigh.png", "img_christmas/christmas_tree.png", "img_christmas/mistletoe.png", "img_christmas/mistletoe.png"));
        list.add(new ListenAnswer(66, "Sleigh", "img_christmas/christmas_tree.png", "img_christmas/sleigh.png", "img_christmas/father_christmas.png", "img_christmas/angle.png", "img_christmas/sleigh.png"));
        list.add(new ListenAnswer(67, "Snowman", "img_christmas/angle.png", "img_christmas/father_christmas.png", "img_christmas/snowman.png", "img_christmas/sleigh.png", "img_christmas/snowman.png"));
        list.add(new ListenAnswer(187, "Bells", "img_christmas/mistletoe.png", "img_christmas/img_bells.png", "img_christmas/snowman.png", "img_christmas/sleigh.png", "img_christmas/img_bells.png"));
        list.add(new ListenAnswer(188, "Christmas Card", "img_christmas/img_christmas_card.png", "img_christmas/christmas_tree.png", "img_christmas/snowman.png", "img_christmas/angle.png", "img_christmas/img_christmas_card.png"));
        list.add(new ListenAnswer(189, "Stocking", "img_christmas/sleigh.png", "img_christmas/image_stocking.png", "img_christmas/father_christmas.png", "img_christmas/snowman.png", "img_christmas/image_stocking.png"));
        list.add(new ListenAnswer(190, "Presents", "img_christmas/snowman.png", "img_christmas/img_presents.png", "img_christmas/christmas_tree.png", "img_christmas/mistletoe.png", "img_christmas/img_presents.png"));
        list.add(new ListenAnswer(191, "Candy Canes", "img_christmas/christmas_tree.png", "img_christmas/sleigh.png", "img_christmas/father_christmas.png", "img_christmas/img_candy_canes.png", "img_christmas/img_candy_canes.png"));
        list.add(new ListenAnswer(192, "Candles", "img_christmas/angle.png", "img_christmas/father_christmas.png", "img_christmas/img_candles.png", "img_christmas/sleigh.png", "img_christmas/img_candles.png"));

        list.add(new ListenAnswer(68, "Black", "img_color/white.png", "img_color/black.png", "img_color/green.png", "img_color/blue.png", "img_color/black.png"));
        list.add(new ListenAnswer(69, "Blue", "img_color/blue.png", "img_color/black.png", "img_color/yellow.png", "img_color/violet.png", "img_color/blue.png"));
        list.add(new ListenAnswer(70, "Brown", "img_color/red.png", "img_color/green.png", "img_color/brown.png", "img_color/violet.png", "img_color/brown.png"));
        list.add(new ListenAnswer(71, "Green", "img_color/white.png", "img_color/violet.png", "img_color/blue.png", "img_color/green.png", "img_color/green.png"));
        list.add(new ListenAnswer(72, "Red", "img_color/blue.png", "img_color/red.png", "img_color/green.png", "img_color/violet.png", "img_color/red.png"));
        list.add(new ListenAnswer(73, "Violet", "img_color/violet.png", "img_color/blue.png", "img_color/white.png", "img_color/green.png", "img_color/violet.png"));
        list.add(new ListenAnswer(74, "White", "img_color/blue.png", "img_color/green.png", "img_color/white.png", "img_color/blue.png", "img_color/white.png"));
        list.add(new ListenAnswer(75, "Yellow", "img_color/green.png", "img_color/yellow.png", "img_color/blue.png", "img_color/black.png", "img_color/yellow.png"));

        list.add(new ListenAnswer(76, "Beef", "img_food/beef.png", "img_food/bread.png", "img_food/rice.png", "img_food/pizza.png", "img_food/beef.png"));
        list.add(new ListenAnswer(77, "Bread", "img_food/beef.png", "img_food/bread.png", "img_food/egg.png", "img_food/cheese.png", "img_food/bread.png"));
        list.add(new ListenAnswer(78, "Cheese", "img_food/rice.png", "img_food/", "img_food/cheese.png", "img_food/beef.png", "img_food/cheese.png"));
        list.add(new ListenAnswer(79, "Egg", "img_food/soup.png", "img_food/hotpot.png", "img_food/beef.png", "img_food/egg.png", "img_food/egg.png"));
        list.add(new ListenAnswer(80, "Hotpot", "img_food/hotpot.png", "img_food/soup.png", "img_food/rice.png", "img_food/bread.png", "img_food/hotpot.png"));
        list.add(new ListenAnswer(81, "Pizza", "img_food/rice.png", "img_food/cheese.png", "img_food/egg.png", "img_food/pizza.png", "img_food/pizza.png"));
        list.add(new ListenAnswer(82, "Rice", "img_food/soup.png", "img_food/rice.png", "img_food/hotpot.png", "img_food/pizza.png", "img_food/rice.png"));
        list.add(new ListenAnswer(83, "Soup", "img_food/hotpot.png", "img_food/beef.png", "img_food/soup.png", "img_food/egg.png", "img_food/soup.png"));


        list.add(new ListenAnswer(84, "Apple", "img_fruit/apple.png", "img_fruit/orange.png", "img_fruit/lemon.png", "img_fruit/eggplant.png", "img_fruit/apple.png"));
        list.add(new ListenAnswer(85, "Orange", "img_fruit/pear.png", "img_fruit/orange.png", "img_fruit/grapes.png", "img_fruit/plums.png", "img_fruit/orange.png"));
        list.add(new ListenAnswer(86, "Jack fruit", "img_fruit/watermelon.png", "img_fruit/pineapple.png", "img_fruit/jack_fruit.png", "img_fruit/mangoes.png", "img_fruit/jack_fruit.png"));
        list.add(new ListenAnswer(87, "Coconut", "img_fruit/cucumber.png", "img_fruit/kiwi.png", "img_fruit/banana.png", "img_fruit/coconut.png", "img_fruit/coconut.png"));
        list.add(new ListenAnswer(88, "Kiwi", "img_fruit/kiwi.png", "img_fruit/jack_fruit.png", "img_fruit/cherry.png", "img_fruit/guava.png", "img_fruit/kiwi.png"));
        list.add(new ListenAnswer(89, "Cucumber", "img_fruit/apple.png", "img_fruit/cucumber.png", "img_fruit/pineapple.png", "img_fruit/orange.png", "img_fruit/cucumber.png"));
        list.add(new ListenAnswer(90, "Mangoes", "img_fruit/orange.png", "img_fruit/coconut.png", "img_fruit/mangoes.png", "img_fruit/plums.png", "img_fruit/mangoes.png"));
        list.add(new ListenAnswer(91, "Strawberry", "img_fruit/plums.png", "img_fruit/kiwi.png", "img_fruit/mangoes.png", "img_fruit/strawberries.png", "img_fruit/strawberries.png"));
        list.add(new ListenAnswer(92, "Watermelon", "img_fruit/watermelon.png", "img_fruit/apple.png", "img_fruit/cucumber.png", "img_fruit/jack_fruit.png", "img_fruit/watermelon.png"));
        list.add(new ListenAnswer(93, "Eggplant", "img_fruit/strawberries.png", "img_fruit/eggplant.png", "img_fruit/cherry.png", "img_fruit/grapes.png", "img_fruit/eggplant.png"));
        list.add(new ListenAnswer(94, "Lemon", "img_fruit/watermelon.png", "img_fruit/apple.png", "img_fruit/lemon.png", "img_fruit/banana.png", "img_fruit/lemon.png"));
        list.add(new ListenAnswer(95, "Banana", "img_fruit/cherry.png", "img_fruit/cucumber.png", "img_fruit/guava.png", "img_fruit/banana.png", "img_fruit/banana.png"));
        list.add(new ListenAnswer(96, "Pear", "img_fruit/pear.png", "img_fruit/guava.png", "img_fruit/grapes.png", "img_fruit/orange.png", "img_fruit/pear.png"));
        list.add(new ListenAnswer(97, "Grapes", "img_fruit/jack_fruit.png", "img_fruit/grapes.png", "img_fruit/apple.png", "img_fruit/coconut.png", "img_fruit/grapes.png"));
        list.add(new ListenAnswer(98, "Cherry", "img_fruit/plums.png", "img_fruit/mangoes.png", "img_fruit/cherry.png", "img_fruit/kiwi.png", "img_fruit/cherry.png"));
        list.add(new ListenAnswer(99, "Pineapple", "img_fruit/banana.png", "img_fruit/apple.png", "img_fruit/orange.png", "img_fruit/pineapple.png", "img_fruit/pineapple.png"));
        list.add(new ListenAnswer(100, "Guava", "img_fruit/pear.png", "img_fruit/kiwi.png", "img_fruit/guava.png", "img_fruit/cherry.png", "img_fruit/guava.png"));
        list.add(new ListenAnswer(101, "Plums", "img_fruit/orange.png", "img_fruit/guava.png", "img_fruit/apple.png", "img_fruit/plums.png", "img_fruit/plums.png"));


        list.add(new ListenAnswer(102, "Rose", "img_flower/rose.png", "img_flower/sun_flower.png", "img_flower/orchid.png", "img_flower/chrysanthemum.png", "img_flower/rose.png"));
        list.add(new ListenAnswer(103, "Aster", "img_flower/rose.png", "img_flower/aster.png", "img_flower/hibiscus.png", "img_flower/flax.png", "img_flower/aster.png"));
        list.add(new ListenAnswer(104, "Carnation", "img_flower/poppy_flower.png", "img_flower/sun_flower.png", "img_flower/carnation.png", "img_flower/lotus.png", "img_flower/carnation.png"));
        list.add(new ListenAnswer(105, "Chrysanthemum", "img_flower/rose.png", "img_flower/flax.png", "img_flower/daffodil.png", "img_flower/chrysanthemum.png", "img_flower/chrysanthemum.png"));
        list.add(new ListenAnswer(106, "Daffodil", "img_flower/daffodil.png", "img_flower/tulip.png", "img_flower/carnation.png", "img_flower/aster.png", "img_flower/daffodil.png"));
        list.add(new ListenAnswer(107, "Flax", "img_flower/rose.png", "img_flower/flax.png", "img_flower/carnation.png", "img_flower/sun_flower.png", "img_flower/flax.png"));
        list.add(new ListenAnswer(108, "Hibiscus", "img_flower/carnation.png", "img_flower/poppy_flower.png", "img_flower/hibiscus.png", "img_flower/orchid.png", "img_flower/hibiscus.png"));
        list.add(new ListenAnswer(109, "Lotus", "img_flower/sun_flower.png", "img_flower/daffodil.png", "img_flower/rose.png", "img_flower/lotus.png", "img_flower/lotus.png"));
        list.add(new ListenAnswer(110, "Orchid", "img_flower/orchid.png", "img_flower/aster.png", "img_flower/sun_flower.png", "img_flower/tulip.png", "img_flower/orchid.png"));
        list.add(new ListenAnswer(111, "Poppy flower", "img_flower/carnation.png", "img_flower/poppy_flower.png", "img_flower/chrysanthemum.png", "img_flower/flax.png", "img_flower/poppy_flower.png"));
        list.add(new ListenAnswer(112, "Sun flower", "img_flower/sun_flower.png", "img_flower/carnation.png", "img_flower/daffodil.png", "img_flower/aster.png", "img_flower/sun_flower.png"));
        list.add(new ListenAnswer(113, "Tulip", "img_flower/rose.png", "img_flower/hibiscus.png", "img_flower/tulip.png", "img_flower/flax.png", "img_flower/tulip.png"));


        list.add(new ListenAnswer(114, "Circle", "img_geometry/circle.png", "img_geometry/triangle.png", "img_geometry/heart.png", "img_geometry/diamond.png", "img_geometry/circle.png"));
        list.add(new ListenAnswer(115, "Cross", "img_geometry/trapezoid.png", "img_geometry/cross.png", "img_geometry/square.png", "img_geometry/rectangle.png", "img_geometry/cross.png"));
        list.add(new ListenAnswer(116, "Diamond", "img_geometry/circle.png", "img_geometry/pyramid.png", "img_geometry/diamond.png", "img_geometry/pentagon.png", "img_geometry/diamond.png"));
        list.add(new ListenAnswer(117, "Hexagon", "img_geometry/circle.png", "img_geometry/diamond.png", "img_geometry/cross.png", "img_geometry/hexagon.png", "img_geometry/hexagon.png"));
        list.add(new ListenAnswer(118, "Heart", "img_geometry/heart.png", "img_geometry/star.png", "img_geometry/triangle.png", "img_geometry/pyramid.png", "img_geometry/heart.png"));
        list.add(new ListenAnswer(119, "Pentagon", "img_geometry/circle.png", "img_geometry/pentagon.png", "img_geometry/diamond.png", "img_geometry/trapezoid.png", "img_geometry/pentagon.png"));
        list.add(new ListenAnswer(120, "Pyramid", "img_geometry/hexagon.png", "img_geometry/heart.png", "img_geometry/pyramid.png", "img_geometry/star.png", "img_geometry/pyramid.png"));
        list.add(new ListenAnswer(121, "Star", "img_geometry/diamond.png", "img_geometry/triangle.png", "img_geometry/cross.png", "img_geometry/star.png", "img_geometry/star.png"));
        list.add(new ListenAnswer(122, "Rectangle", "img_geometry/rectangle.png", "img_geometry/square.png", "img_geometry/triangle.png", "img_geometry/diamond.png", "img_geometry/rectangle.png"));
        list.add(new ListenAnswer(123, "Square", "img_geometry/cross.png", "img_geometry/square.png", "img_geometry/star.png", "img_geometry/heart.png", "img_geometry/square.png"));
        list.add(new ListenAnswer(124, "Trapezoid", "img_geometry/pentagon.png", "img_geometry/hexagon.png", "img_geometry/diamond.png", "img_geometry/trapezoid.png", "img_geometry/trapezoid.png"));
        list.add(new ListenAnswer(125, "Triangle", "img_geometry/pyramid.png", "img_geometry/triangle.png", "img_geometry/pentagon.png", "img_geometry/circle.png", "img_geometry/triangle.png"));


        list.add(new ListenAnswer(126, "Bed", "img_house/bed.png", "img_house/knife.png", "img_house/sofa.png", "img_house/picture.png", "img_house/bed.png"));
        list.add(new ListenAnswer(127, "Bookcase", "img_house/fridge.png", "img_house/bookcase.png", "img_house/chair.png", "img_house/bed.png", "img_house/bookcase.png"));
        list.add(new ListenAnswer(128, "Chair", "img_house/television.png", "img_house/phone.png", "img_house/chair.png", "img_house/bookcase.png", "img_house/chair.png"));
        list.add(new ListenAnswer(129, "Table", "img_house/clock.png", "img_house/sofa.png", "img_house/television.png", "img_house/table.png", "img_house/table.png"));
        list.add(new ListenAnswer(130, "Clock", "img_house/table.png", "img_house/fridge.png", "img_house/clock.png", "img_house/chair.png", "img_house/clock.png"));
        list.add(new ListenAnswer(131, "Chopping board", "img_house/chopping_board.png", "img_house/bookcase.png", "img_house/bed.png", "img_house/sofa.png", "img_house/chopping_board.png"));
        list.add(new ListenAnswer(133, "Knife", "img_house/knife.png", "img_house/chair.png", "img_house/bed.png", "img_house/phone.png", "img_house/knife.png"));
        list.add(new ListenAnswer(134, "Phone", "img_house/television.png", "img_house/picture.png", "img_house/bookcase.png", "img_house/phone.png", "img_house/phone.png"));
        list.add(new ListenAnswer(135, "Picture", "img_house/clock.png", "img_house/picture.png", "img_house/bed.png", "img_house/sofa.png", "img_house/picture.png"));
        list.add(new ListenAnswer(136, "Sofa", "img_house/fridge.png", "img_house/bed.png", "img_house/chopping_board.png", "img_house/sofa.png", "img_house/sofa.png"));
        list.add(new ListenAnswer(137, "Television", "img_house/bed.png", "img_house/television.png", "img_house/bookcase.png", "img_house/knife.png", "img_house/television.png"));

        list.add(new ListenAnswer(138, "Argentina", "img_nation/argentina.png", "img_nation/thailand.png", "img_nation/germany.png", "img_nation/japan.png", "img_nation/argentina.png"));
        list.add(new ListenAnswer(139, "Brazil", "img_nation/mexico.png", "img_nation/brazil.png", "img_nation/vietnam.png", "img_nation/china.png", "img_nation/brazil.png"));
        list.add(new ListenAnswer(140, "Vietnam", "img_nation/japan.png", "img_nation/american.png", "img_nation/vietnam.png", "img_nation/south_africa.png", "img_nation/vietnam.png"));
        list.add(new ListenAnswer(141, "China", "img_nation/mexico.png", "img_nation/thailand.png", "img_nation/brazil.png", "img_nation/china.png", "img_nation/china.png"));
        list.add(new ListenAnswer(142, "England", "img_nation/england.png", "img_nation/vietnam.png", "img_nation/china.png", "img_nation/italian.png", "img_nation/england.png"));
        list.add(new ListenAnswer(143, "Germany", "img_nation/argentina.png", "img_nation/germany.png", "img_nation/japan.png", "img_nation/brazil.png", "img_nation/germany.png"));
        list.add(new ListenAnswer(144, "Italian", "img_nation/south_africa.png", "img_nation/thailand.png", "img_nation/italian.png", "img_nation/mexico.png", "img_nation/italian.png"));
        list.add(new ListenAnswer(145, "American", "img_nation/american.png", "img_nation/argentina.png", "img_nation/vietnam.png", "img_nation/china.png", "img_nation/american.png"));
        list.add(new ListenAnswer(146, "Japan", "img_nation/germany.png", "img_nation/england.png", "img_nation/japan.png", "img_nation/brazil.png", "img_nation/japan.png"));
        list.add(new ListenAnswer(147, "Mexico", "img_nation/italian.png", "img_nation/mexico.png", "img_nation/brazil.png", "img_nation/south_africa.png", "img_nation/mexico.png"));
        list.add(new ListenAnswer(148, "Thailand", "img_nation/germany.png", "img_nation/vietnam.png", "img_nation/china.png", "img_nation/thailand.png", "img_nation/thailand.png"));
        list.add(new ListenAnswer(149, "South africa", "img_nation/italian.png", "img_nation/mexico.png", "img_nation/argentina.png", "img_nation/south_africa.png", "img_nation/south_africa.png"));

        list.add(new ListenAnswer(150, "Board", "img_school/board.png", "img_school/schoolbag.png", "img_school/notebook.png", "img_school/pencil.png", "img_school/board.png"));
        list.add(new ListenAnswer(151, "Book", "img_school/notebook.png", "img_school/book.png", "img_school/crayon.png", "img_school/calendar.png", "img_school/book.png"));
        list.add(new ListenAnswer(152, "Calendar", "img_school/eraser.png", "img_school/ruler.png", "img_school/calendar.png", "img_school/map.png", "img_school/calendar.png"));
        list.add(new ListenAnswer(153, "Teacher", "img_school/calendar.png", "img_school/book.png", "img_school/ruler.png", "img_school/teacher.png", "img_school/teacher.png"));
        list.add(new ListenAnswer(154, "Eraser", "img_school/eraser.png", "img_school/book.png", "img_school/notebook.png", "img_school/ruler.png", "img_school/eraser.png"));
        list.add(new ListenAnswer(155, "Crayon", "img_school/schoolbag.png", "img_school/crayon.png", "img_house/bookcase.png", "img_animal/pig.png", "img_school/crayon.png"));
        list.add(new ListenAnswer(156, "Map", "img_fruit/banana.png", "img_school/map.png", "img_vehicle/ship.png", "img_flower/carnation.png", "img_school/map.png"));
        list.add(new ListenAnswer(157, "NoteBook", "img_christmas/snowman.png", "img_nation/vietnam.png", "img_school/notebook.png", "img_house/clock.png", "img_school/notebook.png"));
        list.add(new ListenAnswer(158, "Globe", "img_school/board.png", "img_school/book.png", "img_school/notebook.png", "img_school/globe.png", "img_school/globe.png"));
        list.add(new ListenAnswer(159, "Ruler", "img_school/ruler.png", "img_vehicle/kawasaki_ninja_h2r.png", "img_school/pencil.png", "img_animal/dog.png", "img_school/ruler.png"));
        list.add(new ListenAnswer(160, "Schoolbag", "img_school/book.png", "img_school/schoolbag.png", "img_flower/rose.png", "img_house/table.png", "img_school/schoolbag.png"));
        list.add(new ListenAnswer(161, "Pencil", "img_color/violet.png", "img_school/ruler.png", "img_food/cheese.png", "img_school/pencil.png", "img_school/pencil.png"));

        list.add(new ListenAnswer(162, "Airplane", "img_vehicle/airplane.png", "img_vehicle/train.png", "img_vehicle/honda_cbr_1000.png", "img_vehicle/truck.png", "img_vehicle/airplane.png"));
        list.add(new ListenAnswer(163, "Bike", "img_vehicle/kawasaki_ninja_h2r.png", "img_vehicle/bike.png", "img_vehicle/ship.png", "img_vehicle/truck.png", "img_vehicle/bike.png"));
        list.add(new ListenAnswer(164, "Bus", "img_animal/pig.png", "img_vehicle/roll_royce.png", "img_vehicle/bus.png", "img_house/television.png", "img_vehicle/bus.png"));
        list.add(new ListenAnswer(165, "Car", "img_vehicle/bus.png", "img_vehicle/train.png", "img_vehicle/truck.png", "img_vehicle/car.png", "img_vehicle/car.png"));
        list.add(new ListenAnswer(166, "Motorbike", "img_vehicle/motorbike.png", "img_vehicle/kawasaki_ninja_h2r.png", "img_food/bread.png", "img_animal/lion.png", "img_vehicle/motorbike.png"));
        list.add(new ListenAnswer(167, "Ship", "img_vehicle/train.png", "img_vehicle/ship.png", "img_christmas/father_christmas.png", "img_vehicle/bus.png", "img_vehicle/ship.png"));
        list.add(new ListenAnswer(168, "Train", "img_vehicle/truck.png", "img_vehicle/bus.png", "img_vehicle/airplane.png", "img_vehicle/train.png", "img_vehicle/train.png"));
        list.add(new ListenAnswer(169, "Excavator", "img_vehicle/excavator.png", "img_school/schoolbag.png", "img_fruit/cherry.png", "img_vehicle/bus.png", "img_vehicle/excavator.png"));
        list.add(new ListenAnswer(170, "Truck", "img_vehicle/bus.png", "img_vehicle/truck.png", "img_vehicle/roll_royce.png", "img_vehicle/bike.png", "img_vehicle/truck.png"));
        list.add(new ListenAnswer(171, "Honda CBR 1000", "img_vehicle/kawasaki_ninja_h2r.png", "img_vehicle/bike.png", "img_vehicle/honda_cbr_1000.png", "img_vehicle/train.png", "img_vehicle/honda_cbr_1000.png"));
        list.add(new ListenAnswer(172, "Roll Royce", "img_vehicle/train.png", "img_vehicle/bus.png", "img_vehicle/truck.png", "img_vehicle/roll_royce.png", "img_vehicle/roll_royce.png"));
        list.add(new ListenAnswer(173, "Kawasaki Ninja H2R", "img_vehicle/honda_cbr_1000.png", "img_vehicle/kawasaki_ninja_h2r.png", "img_nation/germany.png", "img_school/globe.png", "img_vehicle/kawasaki_ninja_h2r.png"));


        list.add(new ListenAnswer(174, "Alcohol", "img_water/alcohol.png", "img_water/coca_cola.png", "img_water/chivas.png", "img_water/tea.png", "img_water/alcohol.png"));
        list.add(new ListenAnswer(175, "Beer", "img_water/ding_tea.png", "img_water/beer.png", "img_water/smoothie.png", "img_water/strongbow.png", "img_water/beer.png"));
        list.add(new ListenAnswer(176, "Chivas", "img_water/beer.png", "img_water/alcohol.png", "img_water/chivas.png", "img_water/strongbow.png", "img_water/chivas.png"));
        list.add(new ListenAnswer(177, "Coca-Cola", "img_water/ding_tea.png", "img_water/tea.png", "img_water/red_bull.png", "img_water/coca_cola.png", "img_water/coca_cola.png"));
        list.add(new ListenAnswer(178, "Coffee", "img_water/coffee.png", "img_water/strongbow.png", "img_water/beer.png", "img_food/soup.png", "img_water/coffee.png"));
        list.add(new ListenAnswer(179, "Ding-Tea", "img_water/milk_tea.png", "img_water/ding_tea.png", "img_water/smoothie.png", "img_water/beer.png", "img_water/ding_tea.png"));
        list.add(new ListenAnswer(180, "Milk-Tea", "img_water/pepsi.png", "img_water/tea.png", "img_water/milk_tea.png", "img_fruit/apple.png", "img_water/milk_tea.png"));
        list.add(new ListenAnswer(181, "Pepsi", "img_water/beer.png", "img_water/chivas.png", "img_water/strongbow.png", "img_water/pepsi.png", "img_water/pepsi.png"));
        list.add(new ListenAnswer(182, "Red Bull", "img_water/red_bull.png", "img_water/pepsi.png", "img_water/chivas.png", "img_water/alcohol.png", "img_water/red_bull.png"));
        list.add(new ListenAnswer(183, "Smoothie", "img_water/coffee.png", "img_water/ding_tea.png", "img_water/smoothie.png", "img_water/beer.png", "img_water/smoothie.png"));
        list.add(new ListenAnswer(184, "Tea", "img_water/red_bull.png", "img_water/chivas.png", "img_water/alcohol.png", "img_water/tea.png", "img_water/tea.png"));
        list.add(new ListenAnswer(185, "Strongbow", "img_water/alcohol.png", "img_water/beer.png", "img_water/strongbow.png", "img_water/chivas.png", "img_water/strongbow.png"));


        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDatabase = Database.getInstance(mContext);
                mDatabase.iTopicDao().insertListenAnswer(list);
            }
        });
    }
}
