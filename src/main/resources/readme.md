1. XmlBeanDefinitionReader считывает декларации бинов, и кладет их в мэпу BeanDefinitions;
2. BeanFactory работает по ним создает бины и складывает в контейнер;
3. Создаются синглтоны (для него destroy-метод работает, для  прототайпа destroy-метод не работает)

BeanPostProcessor - позволяет настраивать бины до того, как они попали в контейнер. 
между его методами вызывается init метод 
(в xml для бина init-method, в annotationConfig - @PostConstruct)

Конструктор вызывается в процессе создания объекта, только потом производится настройка бина;
двухфазовый конструктор - сначала конструктор, потом init-метод.

Proxy для объекта - добавление логики через чтототамBeanPostProcessor. 
Два подхода - 
1. Прокси должен наследоваться от оригинального класса и переопределять его методы - cjlib.
2. Прокси должен имплементировать те же самые интерфейсы - Dynamic Proxy. 
cjlib считается хуже (по производительности, плюс ограничение что не от любого класса можно наследовать, 
что классы могут быть final, final методы и т.п.). Поэтому лучше через интерфейсы. 

InjectRandomIntAnnotationBeanPostProcessor рассчитывает, что будет оригинальный класс, 

Те BeanPostProcessorы, которые что-то меняют в классе, должны это делать не на этапе postProcessBeforeInitialization, 
а на этапе postProcessAfterInitialization;
Получается, что postConstruct всегда работает на оригинальный метод init! 

ProfilingControllerMBean - для мониторинга через java8/bin/JavaVisualVM.exe

ApplicationListener

ContextStartedEvent - контекст начал свое построение
ContextStoppedEvent 
**ContextRefreshedEvent** - перед окончанием построения
ContextClosedEvent

Из любого ивента можно вытащить контекст.

на этапе PostConstruct нет никаких proxy, поэтому профилирование только в sayQuote!

BeanFactoryPostProcessor - позволяет настраивать бин дефинишны, до того, как создаются бины (до всяких BeanPostProcessor-ов)

Добавляем функционал: все бины, которые DeprecatedClass должны быть заменены на новую (не устаревшую) версию

ClassPathBeanDefinitionScanner - это ResourceLoaderAware - создает BeanDefinitions из всех классов, 
над которыми стоит @Component, или другая аннотация, аннотированная @Component

AnnotationConfigApplicationContext. 
Использует AnnotatedBeanDefinitionReader - который ничего не имплементирует (в отличие от BeanDefinitionReader, как с xml)
Он просто является частью ApplicationContext.
Он только регистрирует все JavaConfig.

Кто обрабатывает JavaConfig?
ConfigurationClassPostProcessor (особый BeanFactoryPostProcessor)
Его регистрирует AnnotationConfigApplicationContext.
Он создает бин-дефинишены по @Bean
А так же относится к:
@Import
@ImportResource
@ComponentScan

Обновление prototype в синглтоне и написание кастомного скоупа. 
1. JFrame, у которого цвет пока что не меняется. А нужно, чтобы менялся!
2. ColorFrame - синглтон, а цвет Color - prototype, но нет причин, чтобы для синглтона отдавать разный объект цвета prototype! 
3. Нужно обновить prototype-объект в синглтоне. 
4. Плохое решение - сильный coupling на applicationContext! но работает
