# UI - Your simple helper in creating cool UIs

Example usage:

*Using Builder Pattern*
```java
ExampleProvider.getInstance()
    .getUIProcessor()
    .makeUI()
    .customize(customizer -> {
      customizer.title("Example title");
      customizer.illustrator(illustrator -> {
        illustrator.specialMarker("'next page'", NextPageMarker.class);
        illustrator.options(options -> options.skipSpace(false));
        illustrator.rows(
            "#########",
            "|        |",
            "########'next page'"
            
        );
      });
    })
    .update(1, TimeUnit.SECONDS)
    .button(
        Buttons.DEFAUL_FACTORY.create()
          .stack(new BukkitStack(Material.STONE).named("&c&lExample button"))
          .id('#')
          .action(
              Actions.BUTTON_ACTION_FACTORY.create()
                  .queueable(true)
                  .queuePriority(QueuePriority.HIGH)
                  .<WrappedBukkitClickPacket>handle(packet -> {
                      UIBukkitUser user = packet, getSender ();
                      user.sendMessage("You are clicked on button!");
                  })
          )
    )
    .button(
        Buttons.DEFAUL_FACTORY.create()
            .stack(new BukkitStack(Material.ARROW).named("&cNext page"))
            .marker(NextPageMarker.class)
            .action(
                Actions.BUTTON_ACTION_FACTORY.create()
                    .queueable(true)
                    .queuePriority(QueuePriority.HIGH)
                    .<WrappedBukkitClickPacket>handle(packet -> {
                       UIBukkitUser user = packet, getSender ();
                       user.sendMessage("You are clicked on button!");
                    })
                )
    )
    .button(
        Buttons.DEFAUL_FACTORY.create()
            .stack(new BukkitStack(Material.GLASS).named(" "))
            .id('|')
    );
```

*Using abstraction*

```java
package example;

import com.maxwainer.ui.api.abstraction.def.AbstractUI;
import com.maxwainer.ui.api.holder.ButtonHolder;
import com.maxwainer.ui.api.customizer.Customizer;
import com.maxwainer.ui.api.customizer.Customizer.Builder;

public class SomeClass extends AbstractUI {
  
  @Override
  @NotNull
  public ButtonHolder buttonHolder() {
    return ButtonHolder.create()
        .append(
            Buttons.DEFAUL_FACTORY.create()
                .stack(new BukkitStack(Material.GLASS).named(" "))
                .id('|')
        );
  }

  @Override
  @NotNull
  public <T> Customizer.Builder<T> customizer() {
    return customizer -> {
      customizer.title("Example title");
      customizer.illustrator(illustrator -> {
        illustrator.specialMarker("'next page'", NextPageMarker.class);
        illustrator.options(options -> options.skipSpace(false));
        illustrator.rows(
            "#########",
            "|        |",
            "########'next page'"

        );
      });
    };
  }

}
```