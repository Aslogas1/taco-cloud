//package tacos.data;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//import tacos.Ingredient;
//import tacos.Taco;
//
//import java.sql.Timestamp;
//import java.sql.Types;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Objects;
//
//@Repository
//public class JdbcTacoRepository implements TacoRepository{
//
//    private JdbcTemplate jdbc;
//
//    public JdbcTacoRepository(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    @Override
//    public Taco save(Taco taco) {
//        long tacoId = saveTacoInfo(taco);
//        taco.setId(tacoId);
//        for(Ingredient ingredient : taco.getIngredients()) {
//            saveIngredientToTaCo(ingredient, tacoId);
//        }
//        return taco;
//    }
//
//    private long saveTacoInfo(Taco taco) {
//        taco.setCreateAt(new Date());
//        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
//                "insert into Taco (name, createdAt) values (?, ?)",
//                Types.VARCHAR, Types.TIMESTAMP)
//                .newPreparedStatementCreator(Arrays.asList(taco.getName(),
//                        new Timestamp(taco.getCreateAt().getTime())));
//
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbc.update(psc, keyHolder);
//
//        return Objects.requireNonNull(keyHolder.getKey()).longValue();
//    }
//
//    private void saveIngredientToTaCo(Ingredient ingredient, Long tacoId) {
//        jdbc.update("insert into Taco_Ingredients (taco, ingredient) " +
//                "values (?, ?)", tacoId, ingredient.getId());
//    }
//}
