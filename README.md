# A sample AXIS2 service.

Generates the code from a WSDL file, accepts and validates requests according to the schema.

Automatically creates toString(), equals(), and hachCode() methods for each generated model class.

Authomatically adds bean validation annotations(e.g. @javax.validation.constraints.NotNull) to the generated classes during the code generation phase. To do so it uses the XSD schema and the rules defined in the databinding file.
