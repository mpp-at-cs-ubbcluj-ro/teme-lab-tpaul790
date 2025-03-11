package ro.mpp2025.repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import ro.mpp2025.domain.Car;
import ro.mpp2025.domain.Entity;
import ro.mpp2025.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CarRepository implements Repository<Integer, Car> {
    private JdbcUtils jdbcUtils;
    private static final Logger logger = LogManager.getLogger(CarRepository.class);

    public CarRepository(Properties properties) {
        logger.info("CarRepository initialized");
        jdbcUtils = new JdbcUtils(properties);
    }

    @Override
    public List<Car> findAll() {
        logger.info("Find all cars");
        Connection connection = jdbcUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement("select * from Cars where fuel = ?")){
            preparedStatement.setString(1,"DSL");
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String fuel = resultSet.getString("fuel");
                    String brand = resultSet.getString("brand");
                    int mileage = resultSet.getInt("mileage");
                    Car car = new Car(brand,fuel,mileage);
                    car.setId(id);
                    cars.add(car);
                }
            }
        }catch (SQLException e){
            logger.error(e);
            System.out.println("Error DB");
        }
        return cars;
    }

    @Override
    public Car findOne(Integer integer) {
        return null;
    }

    @Override
    public Car save(Car entity) {
        int result = 0;
        logger.traceEntry("saving tasks {}",entity);
        Connection connection = jdbcUtils.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement("insert into Cars (brand, fuel, mileage) values (?,?,?)")){
            preparedStatement.setString(1, entity.getBrand());
            preparedStatement.setString(2, entity.getFuel());
            preparedStatement.setInt(3, entity.getMileage());
            result = preparedStatement.executeUpdate();
            logger.traceExit("saving tasks {}",entity);
        }catch (SQLException e){
            logger.error(e);
            System.out.println("Error DB");
        }
        if(result < 0)
            return entity;
        return null;
    }

    @Override
    public Car delete(Integer integer) {
        return null;
    }

    @Override
    public Car update(Car entity) {
        int result = 0;
        logger.traceEntry("updating tasks {}",entity);
        Connection connection = jdbcUtils.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement("update Cars set brand = ?, fuel = ?, mileage = ? where id = ?")){
            preparedStatement.setString(1, entity.getBrand());
            preparedStatement.setString(2, entity.getFuel());
            preparedStatement.setInt(3, entity.getMileage());
            preparedStatement.setInt(4, entity.getId());
            result = preparedStatement.executeUpdate();
            logger.traceExit("updating tasks {}",entity);
        }catch (SQLException e){
            logger.error(e);
            System.out.println("Error DB");
        }
        if (result < 0)
            return entity;
        return null;
    }
}
