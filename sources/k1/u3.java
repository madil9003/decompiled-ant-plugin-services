package k1;

/* loaded from: classes.dex */
public class u3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2448g;

    static {
        s1 s1Var = new s1("weight_scale", 30);
        f2448g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("weight", 0, 132, 100.0d, 0.0d, "kg", false, l2.WEIGHT));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("percent_fat", 1, 132, 100.0d, 0.0d, "%", false, l2Var));
        s1Var.h(new s0("percent_hydration", 2, 132, 100.0d, 0.0d, "%", false, l2Var));
        s1Var.h(new s0("visceral_fat_mass", 3, 132, 100.0d, 0.0d, "kg", false, l2Var));
        s1Var.h(new s0("bone_mass", 4, 132, 100.0d, 0.0d, "kg", false, l2Var));
        s1Var.h(new s0("muscle_mass", 5, 132, 100.0d, 0.0d, "kg", false, l2Var));
        s1Var.h(new s0("basal_met", 7, 132, 4.0d, 0.0d, "kcal/day", false, l2Var));
        l2 l2Var2 = l2.UINT8;
        s1Var.h(new s0("physique_rating", 8, 2, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("active_met", 9, 132, 4.0d, 0.0d, "kcal/day", false, l2Var));
        s1Var.h(new s0("metabolic_age", 10, 2, 1.0d, 0.0d, "years", false, l2Var2));
        s1Var.h(new s0("visceral_fat_rating", 11, 2, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("user_profile_index", 12, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
    }

    public u3(s1 s1Var) {
        super(s1Var);
    }
}
