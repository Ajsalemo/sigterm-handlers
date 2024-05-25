using System.Runtime.InteropServices;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.MapGet("/", () =>
{
    string message = "sigterm-handlers-dotnet";
    return message;
})
.WithName("Index")
.WithOpenApi();

PosixSignalRegistration.Create(PosixSignal.SIGTERM, (ctx) =>
{
    Console.WriteLine("Caught SIGTERM, default host is shutting down");
});

app.Run();

